package utils;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dom4jTest {


    private static List<String> tableNames = new ArrayList<>();

    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        tableNames.add("user");
        tableNames.add("permission");
        tableNames.add("role");
        tableNames.add("user_role");
        tableNames.add("role_permission");
        createXml();
        List<String> warnings = new ArrayList<String>();

        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(new File("D:/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println(warnings);
    }


    public static void createXml() throws IOException {

        //1.创建document 对象
        Document document = DocumentHelper.createDocument();

        //2.添加文档声明
        document.addDocType("generatorConfiguration",
                "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        ,"http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd");

        //3.创建 根节点 generatorConfiguration
        Element root = document.addElement("generatorConfiguration");

        //4.添加数据库驱动节点 与 context节点
        Element classPathEntry = root.addElement("classPathEntry");
        Element context = root.addElement("context");

        //5. 设置驱动地址
        classPathEntry.addAttribute("location",
                getPath());

        //6. 设置 context 的 id 以及 targetRuntime
        context.addAttribute("id","DB2Tables");
        context.addAttribute("targetRuntime","MyBatis3");

        //7. context 添加子节点 commentGenerator
        Element commentGenerator =  context.addElement("commentGenerator");
        //7.1  设置属性1
        Element property1 = commentGenerator.addElement("property");
        property1.addAttribute("name","suppressDate");
        property1.addAttribute("value","true");
        //7.2  设置属性2
        Element property2 =  commentGenerator.addElement("property");
        property2.addAttribute("name","suppressAllComments");
        property2.addAttribute("value","true");


        //8. context 添加子节点 jdbcConnection
        Element jdbcConnection = context.addElement("jdbcConnection");
        //8.1 设置参数
        jdbcConnection.addAttribute("driverClass","com.mysql.cj.jdbc.Driver");
        jdbcConnection.addAttribute("connectionURL","jdbc:mysql://localhost/test?serverTimezone=Hongkong&useSSL=false");
        jdbcConnection.addAttribute("userId","root");
        jdbcConnection.addAttribute("password","123456");
        //8.2 设置属性
        Element jdbcConnectionProperty = jdbcConnection.addElement("property");
        jdbcConnectionProperty.addAttribute("name","nullCatalogMeansCurrent");
        jdbcConnectionProperty.addAttribute("value","true");


        //9. 添加 javaTypeResolver 节点
        Element javaTypeResolver = context.addElement("javaTypeResolver");
        Element  javaTypeResolverProperty = javaTypeResolver.addElement("property");
        javaTypeResolverProperty.addAttribute("name","forceBigDecimals");
        javaTypeResolverProperty.addAttribute("value","false");

        //10.添加 javaModelGenerator 节点 (生成model类存放位置)
        Element javaModelGenerator = context.addElement("javaModelGenerator");
        javaModelGenerator.addAttribute("targetPackage","cn.lovehao.entity");
        javaModelGenerator.addAttribute("targetProject","src/test/java");
        //10.1
        Element javaModelGeneratorProperty1 = javaModelGenerator.addElement("property");
        javaModelGeneratorProperty1.addAttribute("name","enableSubPackages");
        javaModelGeneratorProperty1.addAttribute("value","true");
        //10.2
        Element javaModelGeneratorProperty2 = javaModelGenerator.addElement("property");
        javaModelGeneratorProperty2.addAttribute("name","trimStrings");
        javaModelGeneratorProperty2.addAttribute("value","true");


        //11.添加 sqlMapGenerator 节点 （生成映射文件存放位置）
        Element sqlMapGenerator = context.addElement("sqlMapGenerator");
        sqlMapGenerator.addAttribute("targetPackage","cn.lovehao.mapper");
        sqlMapGenerator.addAttribute("targetProject","src/test/java");
        Element sqlMapGeneratorProperty1 = sqlMapGenerator.addElement("property");
        sqlMapGeneratorProperty1.addAttribute("name","enableSubPackages");
        sqlMapGeneratorProperty1.addAttribute("value","true");


        //12.添加 javaClientGenerator 节点 (生成Dao类存放位置)
        Element javaClientGenerator = context.addElement("javaClientGenerator");
        javaClientGenerator.addAttribute("type","XMLMAPPER");
        javaClientGenerator.addAttribute("targetPackage","cn.lovehao.dao");
        javaClientGenerator.addAttribute("targetProject","src/test/java");
        Element javaClientGeneratorProperty1 = javaClientGenerator.addElement("property");
        javaClientGeneratorProperty1.addAttribute("name","enableSubPackages");
        javaClientGeneratorProperty1.addAttribute("value","true");

        //13.配置表格
        for(String s : tableNames){
           Element table =  context.addElement("table");
           table.addAttribute("tableName",s);
            table.addAttribute("domainObjectName",mapObjectStr(s));
            table.addAttribute("enableCountByExample","false");
            table.addAttribute("enableUpdateByExample","false");
            table.addAttribute("enableDeleteByExample","false");
            table.addAttribute("enableSelectByExample","false");
            table.addAttribute("selectByExampleQueryId","false");
        }
        //14.设置生成xml的格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置编码格式
        format.setEncoding("UTF-8");

        //15.生成xml文件
        File file = new File("D:/generatorConfig.xml");

        XMLWriter writer = new XMLWriter(new FileOutputStream(file),format);

        //设置是否转义，默认使用转义字符
        writer.setEscapeText(false);
        writer.write(document);
        writer.close();
        System.out.println("生成rss.xml 成功");
    }


    public static String mapObjectStr(String tableName){
        String[] strs = tableName.split("_");
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < strs.length ; i ++){
            StringBuilder temp = new StringBuilder();
            temp.append(strs[i].substring(0,1).toUpperCase());
            temp.append(strs[i].substring(1));
            builder.append(temp);
        }
        return builder.toString();
    }

    public static String getPath() throws IOException {
//        URL base = Dom4jTest.class.getResource("/");
//        String path = new File(base.getFile(),"mysql-connector-java-8.0.13.jar").getCanonicalPath();
        String path = "D:/src/mybatis-generator-core-1.3.5.jar";
        return path;
    }

}
