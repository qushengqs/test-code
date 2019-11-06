package com.beetest.config;

import com.beetest.model.Circle;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: senne
 * @Date: 2019/11/6 11:12
 * @Version 1.0
 */
@Import({Circle.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Configuration
public class MainConfig {
}
