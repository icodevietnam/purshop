package com.icoding.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({AppConstant.APP_PACKAGE})
@Import(HibernateConfig.class)
public class SpringRootConfig {

}
