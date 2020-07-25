package com.vip8.test.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Package: cn.com.comline.island.upms</p>
 * <p>ClassName: GeneratorTest</p>
 * <p>功能：</p>
 * <p>Copyright (c) www.island.ren 2019</p>
 * <p>author: comline@foxmail.com</p>
 * <p>create: 2019-06-16 15:54</p>
 **/
public class CodeGeneratorTest {

    @Test
    public void generatorCode() {
        //自定义模块名
        final String moduleName = "";
        final String projectPath = "E:/maven项目/xf";//System.getProperty("user.dir");
        //final String projectPath = "/Users/xiongbo/Desktop/proCode/tradeBranch0111/trade/trade-dao";
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
//        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setOutputDir(projectPath + "/src/main/java")//输出目录
                        .setFileOverride(true)// 是否覆盖文件
                        .setActiveRecord(true)// 开启 activeRecord 模式
                        .setEnableCache(false)// XML 二级缓存
                        .setBaseResultMap(true)// XML ResultMap
                        .setBaseColumnList(true)// XML columList
//                        .setKotlin(true) //是否生成 kotlin 代码
                        .setAuthor("zhangfei")
                        // 自定义文件命名，注意 %s 会自动填充表实体属性！
                        .setEntityName("%sEntity")
                        // .setMapperName("%sDao")
                        // .setXmlName("%sDao")
                        // .setServiceName("MP%sService")
                        // .setServiceImplName("%sServiceDiy")
                        // .setControllerName("%sAction")
                        .setServiceName("%sService")
                        .setServiceImplName("%sServiceImpl")
                        .setControllerName("%sController")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        .setDbType(DbType.MYSQL)// 数据库类型
//                        .setTypeConvert(new MySqlTypeConvert() {
//                            // 自定义数据库表字段类型转换【可选】
//                            @Override
//                            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
//                                System.out.println("转换类型：" + fieldType);
//                                 if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
//                                    return DbColumnType.BOOLEAN;
//                                 }
//                                return super.processTypeConvert(globalConfig, fieldType);
//                            }
//                        })
                        .setDriverName("com.mysql.cj.jdbc.Driver")
                        .setUsername("root")
                        //.setPassword("x!c@_d#ev$xcD_SdeAvM")
                        .setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai")
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        // .setDbColumnUnderline(true)//全局下划线命名
                        .setTablePrefix(new String[]{""})// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        .setInclude(new String[]{"t_product","t_purchase_record"}) // 需要生成的表
                        // .setExclude(new String[]{"test"}) // 排除生成的表
                        // 自定义实体，公共字段
                       // .setSuperEntityColumns(new String[]{"id", "creator", "modifier", "is_deleted", "gmt_create", "gmt_modified"})
                        .setTableFillList(tableFillList)


//                //实体类自动继承Entity,不需要也可以
//                .setSuperEntityClass("cn.com.comline.island.core.common.base.model.BaseModel"
                        //.setSuperEntityClass("com.vip8.common.entity.BaseEntityWithExt")
                .setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService")
        // 自定义 service 实现类父类
                .setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl")
//                // 自定义 mapper 父类
//                // .setSuperMapperClass("cn.com.comline.island.core.common.base.mapper.BaseMapper")
//                // 自定义 service 父类
//                 .setSuperServiceClass("cn.com.comline.island.core.common.base.service.BaseService")
//                // 自定义 service 实现类父类
//                 .setSuperServiceImplClass("cn.com.comline.island.core.common.base.service.impl.BaseServiceImpl")
//                // 自定义 controller 父类
//                 .setSuperControllerClass("cn.com.comline.island.core.common.base.controller.BaseController")
                        // 【实体】是否生成字段常量（默认 false）
                        // public static final String ID = "test_id";
                        .setEntityColumnConstant(false)
                        // 【实体】是否为构建者模型（默认 false）
                        // public User setName(String name) {this.name = name; return this;}
                        .setEntityBuilderModel(true)
                        // 【实体】是否为lombok模型（默认 false）<a href="httsetDbColumnUnderlineps://projectlombok.org/">document</a>
                        .setEntityLombokModel(true)
                        // Boolean类型字段是否移除is前缀处理
                        .setEntityBooleanColumnRemoveIsPrefix(true)
                        .setRestControllerStyle(true)
                        .setControllerMappingHyphenStyle(true)
                        .setEntityTableFieldAnnotationEnable(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
                        .setModuleName(moduleName)
                        .setParent("com.map8.xf")// 自定义包路径
                        .setController("controller.inquiry")// 这里是控制器包名，默认 web
                        .setEntity("dao.entity.inquiry")
                        .setMapper("dao.mapper.inquiry")
                        .setService("service.inquiry")
                        .setServiceImpl("service.inquiry.impl")
//        ).setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
//                new InjectionConfig() {
//                    @Override
//                    public void initMap() {
//                        Map<String, Object> map = new HashMap<>();
//                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                        this.setMap(map);
//                    }
//                }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
//                        "/templates/mapper.mapper.ftl") {
//                    // 自定义输出文件目录
//                    @Override
//                    public String outputFile(TableInfo tableInfo) {
//                        // 自定义输入文件名称================================模块名（自己设置）
//                        return projectPath + "/src/main/resources/cn/com/comline/island/" + moduleName + "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//                    }
//                }))
        ).setTemplate(
                // 关闭默认 mapper 生成，调整生成 至 根目录
                new TemplateConfig()
                        // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                        // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                        .setController("templates/controller.java")
                        .setController(null)
                        .setEntity("templates/entity.java")
                        .setMapper("templates/mapper.java")
                        .setXml(null)
                        .setXml("templates/mapper.mapper")
                        .setService("templates/service.java")
                        .setServiceImpl("templates/serviceImpl.java")

        );
        // 执行生成
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
//        System.err.println(mpg.getCfg().getMap().get("abc"));
    }
}

