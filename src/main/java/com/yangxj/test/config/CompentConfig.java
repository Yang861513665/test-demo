package com.yangxj.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * @author yangxj
 * @date 2019-08-26 18:36
 */
@Configuration
public class CompentConfig {
    @Bean
    FreeMarkerConfigurer freeMarkerConfig(DataBaseTemplateLoader dataBaseTemplateLoader){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        // 加入自定义 templateLoader
        freeMarkerConfigurer.setPostTemplateLoaders(dataBaseTemplateLoader);
        return freeMarkerConfigurer;
    }
}
