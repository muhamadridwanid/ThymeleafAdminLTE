/*
 * Copyright (c) 2017,  Muhamadridwan.id
 * All rights reserved.
 */
package id.muhamadridwan.starter.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 *
 * @author mridwan
 */
@Configuration
public class Webconfig {

    @Bean
    public ServletRegistrationBean h2ServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;
    }

}
