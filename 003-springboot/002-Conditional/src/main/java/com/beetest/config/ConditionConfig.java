package com.beetest.config;

import com.beetest.bean.ConditionBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: senne
 * @Date: 2019/11/6 11:37
 * @Version 1.0
 */
@Configuration
@Conditional(MyCondition.class)
public class ConditionConfig {

    @Bean
    public ConditionBean conditionBean(){
        return new ConditionBean();
    }
}
