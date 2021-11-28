import com.bench.lang.base.clasz.utils.ClassUtils;
import com.bench.lang.base.file.FilePathUtils;
import com.bench.lang.base.string.utils.StringUtils;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.platform.commons.util.ClassLoaderUtils;

import java.io.File;

/**
 * @className GenRpService
 * @autor cold
 * @DATE 2021/6/17 2:02
 **/
@Slf4j
public class GenRpService {
    private final static String APP_CODE = "gotonecore";
    private final static String TALBES = "*";

    private static String baseDirPath = "D:\\bench_sources\\yuan\\"+APP_CODE+"\\repository\\src\\main\\java\\com\\yuan\\gotonecore\\repository\\";

    @Test
    public void genRpServiceByMapper(){

        FilePathUtils.visit(baseDirPath+"mapper", new FilePathUtils.FileAndPathVisitor() {
            @SneakyThrows
            @Override
            public void visitFile(File file) {

                String[] tablesArr = StringUtils.split(TALBES,",");
                if (StringUtils.contains(file.getName(),".java") && (StringUtils.equals("*",TALBES) || StringUtils.equals(file.getName(), TALBES)) ) {
                    // 读取mapper的内容
                    genRpServiceByMapper(file);
                }
            }

            @Override
            public boolean visitPath(File path) {
                return false;
            }
        });
    }
    @SneakyThrows
    public String genRpServiceByMapper(File file){
        //获取文件的包名
        String mapperContent = FileUtils.readFileToString(file, "utf-8");
        String methodStrContent = StringUtils.substringBetween(mapperContent,"{","}");
        String[] methodArr = StringUtils.split(methodStrContent,";");
        StringBuffer insertContentSb = new StringBuffer();
        for (String methodStr : methodArr) {
            insertContentSb.append(StringUtils.substringAfter(methodStr,"*/")).append(";");
        }
        //获取RpService
        String RpServiceName = StringUtils.replace(file.getName(),"Mapper","RpService");
        File RpServiceFile = new File(baseDirPath+"service\\"+RpServiceName);
        StringBuffer rpServiceContentBf =  new StringBuffer(FileUtils.readFileToString(RpServiceFile, "utf-8"));
        rpServiceContentBf.insert(StringUtils.indexOf(rpServiceContentBf,"{")+1,"\r\n"+insertContentSb);
        FileUtils.writeStringToFile(RpServiceFile, rpServiceContentBf.toString(), "utf-8", false);

        return "";
    }

}
