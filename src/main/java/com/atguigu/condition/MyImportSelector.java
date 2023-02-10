package com.atguigu.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.atguigu.bean.Yellow","com.atguigu.bean.Blue"};
        //new  new String[]{"需要将哪些类导入组件，以全类名的方式传入"};
    }
}
