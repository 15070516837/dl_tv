package com.tv.generator;

import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: dl_tv
 * @description:
 * @author: Json'
 * @create: 2023-05-13 00:29
 **/

public class NewCodeGenerator {

    /**
     * 代码生成入口
     * 注意： 请先修改resources目录下的generator.properties文件中的配置
     */
    public static void main(String[] args) {
        doGenerator();
        getPath();
    }


    /**
     * 代码生成实现
     * 提示：如果不需要生成controller相关代码，设置packageConfig中的controller为""，设置templateConfig中的controller为null
     */
    private static void doGenerator() {
        // 建立数据库连接
        DataSourceConfig dsc = new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/dl_tv?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8", "root", "libin123123").build();

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator(dsc);
        // 模块名称
        String moduleName = "dl_tv";
        // 项目目录
        String projectPath = "D:\\JavaCode\\redis";
        // 作者名称
        String author = "Json";
        // 基础包路径
        String packagePath = "com.tv.business";
        // 需要生成的表
        String tables = "tv_type";

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig
                .Builder()
                .outputDir(projectPath + "/" + moduleName + "/src/main/java")
                .author(author)
//                .openDir("true".equals(openDir))
                .commentDate("yyyy-MM-dd HH:mm:ss")
                .build();

        // 包配置
        PackageConfig packageConfig = new PackageConfig
                .Builder()
                .parent(packagePath)
//                .moduleName(moduleName)
                .controller("")
                .entity("entity")
                .mapper("mapper")
                .service("service")
                .serviceImpl("service.impl")
                .moduleName(null)
                .build();

        // 配置模板
        String absolutePath = File.separator + "templates";
        String mapperTempPath = absolutePath + File.separator + "MapperP";
        String entityTempPath = absolutePath + File.separator + "EntityP";
        String serviceTempPath = absolutePath + File.separator + "ServiceP";
        String serviceImplTempPath = absolutePath + File.separator + "ServiceImplP";
        TemplateConfig templateConfig = new TemplateConfig
                .Builder()
                .mapper(mapperTempPath)
                .service(serviceTempPath)
                .serviceImpl(serviceImplTempPath)
                .entity(entityTempPath)
                .mapperXml(null)
                .controller(null)
                .build();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig
                .Builder()
                .addInclude(tables.split(","))
                .entityBuilder()
                .naming(NamingStrategy.underline_to_camel)
//                .enableLombok()
//                .controllerBuilder()
//                .enableRestStyle()
                .build();

        mpg.global(globalConfig);
        mpg.packageInfo(packageConfig);
        mpg.template(templateConfig);
        mpg.strategy(strategyConfig);
        // 开始生成代码文件
        mpg.execute(new FreemarkerTemplateEngine());
    }


    /**
     * 获取当前项目本地磁盘目录
     */
    private static void getPath() {
        System.out.println("当前项目本地磁盘目录->" + System.getProperty("user.dir"));
    }


}
