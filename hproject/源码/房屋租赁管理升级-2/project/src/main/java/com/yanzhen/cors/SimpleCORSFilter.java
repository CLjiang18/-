package com.yanzhen.cors;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleCORSFilter {

// implements Filter {

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse response2= (HttpServletResponse) response;
//        response2.setHeader("Access-Control-Allow-Origin","*");
//
//        response2.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD");
//
//        response2.setHeader("Access-Control-Max-Age", "3600");
//
//        response2.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, authority, content-type, version-info, X-Requested-With");
//
//        chain.doFilter(request, response);
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
}
