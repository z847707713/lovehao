package cn.lovehao.Utils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIPUtils {

    /**
     * @param sourceFilePath  压缩源路径
     * @param toFilePath       压缩目的路径
     */
    public static void compress(String sourceFilePath,String toFilePath){
        File source = new File(sourceFilePath);

        if(!source.exists()){
            throw new RuntimeException(sourceFilePath + "不存在");
        }

        File zipFile = new File(toFilePath);

        try{
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            String baseDir = "";
            compressbyType(source, zos, baseDir);
            zos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void compressbyType(File source, ZipOutputStream zos, String baseDir) {

        if(!source.exists()){
            return;
        }
        System.out.println("压缩路径" + baseDir + source.getName());
        //判断文件是否是文件，如果是文件调用compressFile方法,如果是路径，则调用compressDir方法；

        if(source.isFile()){
            compressFile( source, zos, baseDir);
        } else if (source.isDirectory()) {
            //src是文件夹，调用此方法
            compressDir(source, zos, baseDir);
        }

    }


    private static void compressFile(File file, ZipOutputStream zos, String baseDir) {
        if (!file.exists())
            return;
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            ZipEntry entry = new ZipEntry(baseDir + file.getName());
            zos.putNextEntry(entry);
            int count;
            byte[] buf = new byte[1024];
            while ((count = bis.read(buf)) != -1) {
                zos.write(buf, 0, count);
            }
            bis.close();

        } catch (Exception e) {
            // TODO: handle exception

        }
    }

    private static void compressDir(File dir, ZipOutputStream zos, String baseDir) {
        if (!dir.exists())
            return;
        File[] files = dir.listFiles();
        if(files.length == 0){
            try {
                zos.putNextEntry(new ZipEntry(baseDir + dir.getName()+File.separator));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (File file : files) {
            compressbyType(file, zos, baseDir + dir.getName() + File.separator);
        }
    }


}
