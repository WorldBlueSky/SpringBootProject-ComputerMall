package com.study.config;

import com.study.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器拦截器的注册
 */
@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

    /**
     * 将自定义的拦截器进行注册到项目当中
     * @param registry 注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 完成拦截器的注册，所有的请求都会被拦截，所以要配置白名单和黑名单
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/bootstrap3/**",
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/web/login.html",
                        "/web/register.html",
                        "/web/index.html",
                        "/web/product.html",
                        "/index.html",
                        "/users/reg",
                        "/users/login"
                );
    }
}
