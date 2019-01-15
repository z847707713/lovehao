package cn.lovehao.controller;

import cn.lovehao.Utils.GeneratorUtils;
import cn.lovehao.entity.GeneratorInfo;
import cn.lovehao.service.GeneratorService;
import cn.lovehao.service.TablesService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

@Controller
public class GeneratorController {

    @Autowired
    GeneratorService generatorService;

    @RequestMapping("/generator")
    public ResponseEntity<byte[]> generator(GeneratorInfo info) throws IOException {
        if(generatorService.generator(info)){
            String path = info.getGenerateJavaFilePath()+ ".zip";
            File file = new File(path);
            HttpHeaders headers = new HttpHeaders();//http头信息
            String downloadFileName = new String("生成代码.zip".getBytes("UTF-8"),"iso-8859-1");//设置编码
            headers.setContentDispositionFormData("attachment", downloadFileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
           return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
        }
        return null;
    }

}
