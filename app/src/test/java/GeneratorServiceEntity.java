import static com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID;
import static com.baomidou.mybatisplus.generator.config.rules.DateType.ONLY_DATE;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.bench.lang.base.string.utils.StringUtils;
import org.junit.Test;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @author K神
 * @date 2017/12/18
 */
public class GeneratorServiceEntity {

    private static final String dbUrl
            = "jdbc:mysql://felo-minutes-test.cmnaoioyx36v.ap-northeast-1.rds.amazonaws.com:3306/local_gotonecore?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8";
    private static final String packageName = "com.yuan.gotonecore.repository";
    private static final String userName = "admin";
    private static final String password = "JBMrJLnZrEpp6w5qD6wU";
    private static final String outPutDir = "../repository/src/main/java";
    private static final Boolean serviceNameStartWithI = false;

    @Test
    public void generateAllCode() {
        generateByTables(serviceNameStartWithI, packageName, "tem_user");
    }

   @Test
    public void generateOnlyEntity() {
        generateEntity(serviceNameStartWithI, packageName, "gtc_mail_out_history_body");
    }

    private void generateEntity(boolean serviceNameStartWithI, String packageName,
                                String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl).setUsername(userName)
                .setPassword(password)
                .setDriverName("com.mysql.cj.jdbc.Driver");

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(false)
                .setChainModel(true)
                .setEntityLombokModel(true)
                .setControllerMappingHyphenStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames)
                .setEntityColumnConstant(true).setTablePrefix("gtc");

        //修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setOpen(false)
                .setAuthor("cold_auto")
                .setOutputDir(outPutDir)
                .setDateType(ONLY_DATE)
                .setIdType(ASSIGN_ID)
                .setFileOverride(true)
                .setEnableCache(true)
                .setControllerName(null)
                .setEnableCache(false)
                .setBaseColumnList(true)
                .setBaseResultMap(false)
                .setSwagger2(true);

        if (!serviceNameStartWithI) {
            config.setServiceName("%sRpService");
            config.setServiceImplName("%sRpServiceImpl");
            config.setEntityName("%sDO");

        }

        TemplateConfig tc = new TemplateConfig();
        //不生成controller,service,mapper,xml,仅生成实体
        tc.setController(null);
        tc.setService(null);
        tc.setServiceImpl(null);
        tc.setMapper(null);
        tc.setXml(null);
        //tc.setEntity("gotonecores/custom.entity.java.vm");
        //tc.setEntity(null);
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setTemplate(tc)
                .setPackageInfo(new PackageConfig()
                        .setParent(packageName)
                        .setMapper("mapper")
                        .setXml("mapper")
                        .setEntity("entity"))
                .execute();
    }

    private static void generateByTables(boolean serviceNameStartWithI, String packageName,
                                         String... tableNames) {

        GlobalConfig config = new GlobalConfig();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl).setUsername(userName)
                .setPassword(password)
                .setDriverName("com.mysql.jdbc.Driver");

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(false)
                .setChainModel(true)
                .setEntityLombokModel(true)
                .setControllerMappingHyphenStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames)
                .setEntityColumnConstant(true)
                .setLogicDeleteFieldName("del")
                .setVersionFieldName("version").setTablePrefix("tem");

        //修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setOpen(false)
                .setAuthor("cold")
                .setOutputDir(outPutDir)
                .setDateType(ONLY_DATE)
                .setIdType(ASSIGN_ID)
                .setEnableCache(true)
                .setFileOverride(false)
                .setControllerName(null)
                .setEnableCache(false)
                .setBaseColumnList(true)
                .setBaseResultMap(false)
                .setSwagger2(true);

        if (!serviceNameStartWithI) {
            config.setServiceName("%sRpService");
            config.setServiceImplName("%sRpServiceImpl");
            config.setEntityName("%sDO");
        }

        TemplateConfig tc = new TemplateConfig();
        //不生成controller,service
        tc.setController(null);
        tc.setService(null);
        tc.setServiceImpl(null);
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setTemplate(tc)
                .setPackageInfo(new PackageConfig()
                        .setParent(packageName)
                        .setEntity("entity")
                        .setMapper("mapper")
                        .setXml("mapper")
                        .setService("service"))
                .execute();

    }

}
