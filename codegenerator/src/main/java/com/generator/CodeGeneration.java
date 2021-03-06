package com.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fumj
 * @projectName api
 * @description:
 * @date 2019/5/2119:56
 */
@Slf4j
public class CodeGeneration {

    public static void main(String[] args) throws IOException {
        generator();
    }

    @SuppressWarnings({"AlibabaMethodTooLong", "AlibabaRemoveCommentedCode"})
    public static void generator() throws IOException {
        String modelName = "organization";
        String[] tables = {"t_collaborate_organization"};

        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = "D:\\work_code\\financial-service-platform\\fsp-services\\fsp-organization";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("fumj");// 作者
        gc.setIdType(IdType.ID_WORKER);
//        gc.setOpen(false);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("l!vWT#mL93");
        dsc.setUrl("jdbc:mysql://172.16.24.110:3306/fsp?serverTimezone=UTC&useUnicode=true&useSSL=false" +
                "&characterEncoding=utf8");
//                dsc.setUsername("root");
//        dsc.setPassword("root");
//        dsc.setUrl("jdbc:mysql://localhost:3306/mq_message?serverTimezone=UTC&useUnicode=true&useSSL=false" +
//                "&characterEncoding=utf8");

        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[]{"t_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(tables); // 需要生成的表
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("dao");
        pc.setEntity("model");
        pc.setModuleName(modelName);
        pc.setParent("cn.com.citydo");
//        pc.setParent("com.rabbitmq.demo");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        String mapTemplateConfig = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(mapTemplateConfig) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }

        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("controller.java.vm");
//        templateConfig.setController(null);
//        templateConfig.setService(null);
//        templateConfig.setServiceImpl(null);

//        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 执行生成
        mpg.execute();

    }

}
