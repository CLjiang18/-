package com.yanzhen.cors;

/**
 * 全局跨域配置类
 */
import com.yanzhen.interceptor.LoginIntercepter;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration

public class CorsConfig extends WebMvcConfigurerAdapter {

    @Override

    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","OPTIONS")
                .maxAge(3600);
    }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new LoginIntercepter())//添加拦截器
                    .addPathPatterns("/**") //拦截所有请求
                    .excludePathPatterns("/login");//对应的不拦截的请求
        }

    }



