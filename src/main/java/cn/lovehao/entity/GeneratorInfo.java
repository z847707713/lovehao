package cn.lovehao.entity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GeneratorInfo {

    public GeneratorInfo() throws IOException {
        String path = new File(GeneratorInfo.class.getResource("/").getFile()
                + "mybatis-generator-core-1.3.5.jar" ).getCanonicalPath();
        System.out.println(path);
        driverPath = path;

        String path2 = new File(GeneratorInfo.class.getResource("/").getFile()).getParentFile().getCanonicalPath();
        path2 += "/generated-sources";
        System.out.println(path2);
        File file = new File(path2);
        if(!file.exists()){
            file.mkdir();
        }
        generateJavaFilePath = path2;
        entityPath = "cn.lovehao.entity";
        daoPath = "cn.lovehao.dao";
        mapperPath = "cn.lovehao.mapper";
    }

    private String driverPath;  //数据库驱动路径

    private String generateXmlPath;  //生成的XML 文件的保存路径

    private String generateJavaFilePath; // 生成的java文件保存路径

    private String entityPath; //实体类的包路径

    private String daoPath;    //dao层的包路径

    private String mapperPath;  //mybatis 映射xml文件路径

    private List<String> tableNames;

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public String getGenerateXmlPath() {
        return generateXmlPath;
    }

    public void setGenerateXmlPath(String generateXmlPath) {
        this.generateXmlPath = generateXmlPath;
    }

    public String getGenerateJavaFilePath() {
        return generateJavaFilePath;
    }

    public void setGenerateJavaFilePath(String generateJavaFilePath) {
        this.generateJavaFilePath = generateJavaFilePath;
    }

    public String getEntityPath() {
        return entityPath;
    }

    public void setEntityPath(String entityPath) {
        this.entityPath = entityPath;
    }

    public String getDaoPath() {
        return daoPath;
    }

    public void setDaoPath(String daoPath) {
        this.daoPath = daoPath;
    }

    public String getMapperPath() {
        return mapperPath;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    public List<String> getTableNames() {
        return tableNames;
    }

    public void setTableNames(List<String> tableNames) {
        this.tableNames = tableNames;
    }
}
