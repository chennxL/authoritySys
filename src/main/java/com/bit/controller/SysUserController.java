package com.bit.controller;

import com.bit.config.redis.RedisService;
import com.bit.utils.JwtUtils;
import com.bit.utils.Result;
import com.bit.vo.TokenVo;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/SysUser")
public class SysUserController {

    @Resource
    private JwtUtils jwtUtils;

    @Resource
    private RedisService redisService;

//    刷新token的方法
    @PostMapping("refreshToken")
    public Result refreshToken(HttpServletRequest request){
//        从header中获取token信息
        String token = request.getHeader("token");
//        判断header头部是否存在token信息
        if(ObjectUtils.isEmpty(token)){
//            从请求参数中获取token
            token = request.getParameter("token");
        }
//        从Spring security上下文中获取用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        获取用户信息
        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
//        定义变量，保存新的token信息
        String  newToken = "";
//        验证提交过来的token信息是否是合法的
        if(jwtUtils.validateToken(token,userDetails)){
//            重新生成新的token
            newToken=jwtUtils.refreshToken(token);
        }
//        获取本次token到期的时间
        long expireTime = Jwts.parser()
                .setSigningKey(jwtUtils.getSecret())
                .parseClaimsJws(newToken.replace("jwt_",""))
                .getBody().getExpiration().getTime();
//清除原来的token信息
        String oldTokenKey = "token_"+token;
        redisService.del(oldTokenKey);
//        将新的token放入缓存中
        String newTokenKey = "token_"+newToken;
        redisService.set(newTokenKey,newToken,jwtUtils.getExpiration()/1000);
//        创建TokenVo对象
        TokenVo tokenVo = new TokenVo(expireTime,newToken);
//        返回数据
        return Result.ok(tokenVo).message("token刷新成功");
    }
}