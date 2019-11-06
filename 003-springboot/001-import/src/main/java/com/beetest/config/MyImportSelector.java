package com.beetest.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: senne
 * @Date: 2019/11/6 11:16
 * @Version 1.0
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.beetest.model.Triangle"};
    }
}
