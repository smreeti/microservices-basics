package com.smriti.interceptorservice.interceptor;

import com.smriti.interceptorservice.exceptionHandler.UnauthorisedException;
import com.smriti.interceptorservice.utility.JWTTokenUtility;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException {

        //IGNORE JWT TOKEN AUTHENICATION FOR LOGIN API
        if (request.getRequestURI().startsWith("/login")) {
            return true;
        } else {
            String token = JWTTokenUtility.resolveToken(request);
            if (!Objects.isNull(token) && JWTTokenUtility.validateToken(token)) {
                return true;
            } else {
                throw new UnauthorisedException("Request not authorized, please contact system administrator.",
                        "Unmatched JWT token.");
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}

