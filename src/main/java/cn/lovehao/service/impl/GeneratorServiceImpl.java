package cn.lovehao.service.impl;

import cn.lovehao.Utils.GeneratorUtils;
import cn.lovehao.Utils.ZIPUtils;
import cn.lovehao.entity.GeneratorInfo;
import cn.lovehao.service.GeneratorService;
import cn.lovehao.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
