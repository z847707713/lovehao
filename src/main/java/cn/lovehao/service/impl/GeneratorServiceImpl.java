package cn.lovehao.service.impl;

import cn.lovehao.Utils.GeneratorUtils;
import cn.lovehao.Utils.ZIPUtils;
import cn.lovehao.entity.GeneratorInfo;
import cn.lovehao.service.GeneratorService;
import cn.lovehao.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    TablesService tablesService;

    @Override
    public boolean generator(GeneratorInfo info) {

        info.setTableNames(tablesService.getAllTablesName());
        try {
            GeneratorUtils.createXml(info);
            String path = info.getGenerateJavaFilePath();
            ZIPUtils.compress(path,path+".zip");
            //TODO:删除生成的文件
            //如果多次生成，mapper.xml 文件中会有重复
            //这里把文件删除，每次重新生成
            File file = new File(path);
            deleteDir(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 递归删除目录
     * @param dir
     * @return
     */
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

}
