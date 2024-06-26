package com.bit.config.security.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bit.utils.Result;
import com.bit.utils.ResultCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//认证用户访问无权限时处理器
@Component
public class CustomerAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        设置响应的编码格式
        response.setContentType("application/json;charset=utf-8");

//获取输出流
        ServletOutputStream outputStream = response.getOutputStream();

        //        将结果转化成json格式
        String result = JSON.toJSONString(Result.error().code(ResultCode.NO_AUTH).message("无权限访问，请联系管理员"), SerializerFeature.DisableCircularReferenceDetect);
//        将结果保存到输出中写好
        outputStream.write(result.getBytes(StandardCharsets.UTF_8));
//        关闭流
        outputStream.flush();
        outputStream.close();
    }
}
