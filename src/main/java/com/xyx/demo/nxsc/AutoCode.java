package com.xyx.demo.nxsc;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * ClassName: AutoCode
 * Description:
 * date: 2020/11/16 9:15
 *
 * @author Handsome xuanxuan
 */
public class AutoCode {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("xyx");   // 作者
        gc.setOpen(false);      //生成代码后是否打开文件夹
        gc.setServiceName("%sService");  // 设置Service接口生成名称,这样生成接口前面就不会有 I
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:kingbase8://localhost:54321/USERDB");
        dsc.setDriverName("com.kingbase8.Driver");
        dsc.setUsername("****");
        dsc.setPassword("****");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("sys"); // 模块名称, 这里可以根据不同模块来写
        pc.setParent("com.xyx.demo"); // 父包名
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        /*strategy.setSuperControllerClass("com.xyx.demo.controller");
        strategy.setSuperEntityClass("com.xyx.demo.entity");*/
//        strategy.setTablePrefix("tb_");
        strategy.setEntityLombokModel(true);
        //人大金仓数据库，注意大写
        strategy.setInclude("TEA_STU");  // 如果要生成多个,这里可以传入String[]
        mpg.setStrategy(strategy);
        mpg.execute();

    }
}
