package com.example.lbdrestapi.Filters;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Order(2)
//@Component
//public class AuthorizationStudentFilter extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain)
//            throws ServletException,
//            IOException {
//        String header=request.getHeader("role");
//
//        if (header.equals("TEACHER_ROLE") || header.equals("STUDENT_ROLE")) {
//            filterChain.doFilter(request, response);
//
//        }
//        else response.sendError(HttpStatus.UNAUTHORIZED.value(), "Error: User unauthorized");
//
//    }
//
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        String path = request.getRequestURI();
//        return path.startsWith("/teachers");
//    }
//}

