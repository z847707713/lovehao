package listener;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResourceListener {

    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

    private WatchService ws;

    private String listenerPath;

    private ResourceListener(String path) {
        try {
            ws = FileSystems.getDefault().newWatchService();
            this.listenerPath = path;
            start();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        fixedThreadPool.execute(new Listener(ws,this.listenerPath));
    }

    /**
     * 对外提供的静态方法，只需要传入要监听的目录
     * @param path
     * @throws IOException
     */
    public static void addListener(String path) throws IOException {
        ResourceListener resourceListener = new ResourceListener(path);
        Path p = Paths.get(path);
        p.register(resourceListener.ws,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
    }

    public static void main(String[] args) throws IOException {
        ResourceListener.addListener("F:\\");
        ResourceListener.addListener("d:\\");
    }

}

class Listener implements Runnable{

    private WatchService service;

    private String rootPath;

    public Listener(WatchService service, String rootPath) {
        this.service = service;
        this.rootPath = rootPath;
    }

    @Override
    public void run() {

        try {
            while(true){
                WatchKey watchKey = service.take();
                List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
                for(WatchEvent<?> event : watchEvents){
                    System.out.println("[" + rootPath + event.context() + "]文件发生了[" + event.kind()+"]事件" +
                            event.count());
                }
                watchKey.reset();
            }
         } catch (InterruptedException e) {
            e.printStackTrace();
         } finally {
            System.out.println("sfdsf");
            try{
                service.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
