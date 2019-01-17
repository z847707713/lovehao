package cn.lovehao.listener;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchService;

public class WatchFilePathTask extends Thread {

    private static String filePath ;

    private WatchService watchService;

    @Override
    public void run() {

        try{

            //获取监控服务
            watchService = FileSystems.getDefault().newWatchService();
            Path path =FileSystems.getDefault().getPath(filePath);
            final String todayFormat = "yyyy-MM-dd";

            File existFile = new File(filePath);

            //启动时检查是否有未解析的符合要求的文件


        } catch (Exception e){

        }

    }
}
