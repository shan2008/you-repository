package com.you.learn;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by syou on 2017/7/4.
 */
public class loginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        Enumeration<String> enumeration=filterConfig.getInitParameterNames();
        while(enumeration.hasMoreElements()){
            String parameterValue=filterConfig.getInitParameter(enumeration.nextElement());
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("***loginFilter开始执行*****");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("******loginFilter执行完毕******");
    }

    @Override
    public void destroy() {

    }
}
