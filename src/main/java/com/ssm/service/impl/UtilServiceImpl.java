package com.ssm.service.impl;

import com.ssm.service.UtilService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxx
 * @create 2021-09-28
 */
@Service("utilService")
public class UtilServiceImpl implements UtilService {
    @Override
    public Object addImg(MultipartFile[] files, String path){
        List<String> list = new ArrayList<>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String filePath = path + "/" + i + ".jpg";
                File targetFile = new File("E:/SourcesServer" + filePath);
                if (!file.isEmpty()) {
                    try {
                        file.transferTo(targetFile);
                        list.add("http://localhost:8090" + filePath);
                    } catch (IOException e) {
                        return "存储第" + i + "张图片失败!";
                    }
                }
            }
            return list;
        }
        return "图片上传失败!";
    }
}
