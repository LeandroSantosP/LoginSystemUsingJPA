package com.SpringBootAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public Logger logger() {
        return new Logger();
    }

    @Bean
    public LazyBean lazyBean() {
        return new LazyBean();
    }
}
