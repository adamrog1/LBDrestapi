package com.example.lbdrestapi.Interceptors;

import com.example.lbdrestapi.Service.AuthorizationService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    AuthorizationService authorizationService;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        String header=request.getHeader("role");
        return authorizationService.isAuthorized(request.getRequestURI(), header);
    }
}
