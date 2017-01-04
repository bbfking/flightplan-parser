package com.csair.soc.fltplan.parser.util;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pfXiong on 2017/1/4.
 */
public abstract class FileUtil {
    public static List<File> getFileList(String path){
        return getFileList(path,"");
    }

    /**
     * 获取目录下的所有文件
     * @param path
     * @param fileType
     * @return
     */
    public static List<File> getFileList(String path,final String fileType) {
        File file = new File(path);
        List<File> result = new ArrayList<File>();
        if(!file.exists()){
            throw new RuntimeException("path not exists:"+file.getAbsolutePath());
        }
        if (!file.isDirectory()) {
            result.add(file);
        } else {
            File[] directoryList = file.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    if (file.isFile() && file.getName().endsWith(fileType)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            for (int i = 0; i < directoryList.length; i++) {
                result.add(directoryList[i]);
            }
        }
        return result;
    }
}

