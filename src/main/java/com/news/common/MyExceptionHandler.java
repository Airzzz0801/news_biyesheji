package com.news.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Component("MyExceptionHandler")  
public class MyExceptionHandler extends SimpleMappingExceptionResolver {  
    private Logger logger = Logger.getLogger(MyExceptionHandler.class);  
  
    @Override  
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {  
        return getModelAndView("admin_login", ex);  
    }  
}  
