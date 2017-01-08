package com.csair.soc.fltplan.parser.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ReadYaml {

    private static Logger logger = LogManager.getLogger(ReadYaml.class);
	
    private static final String PATTERN_REGEX = ".*%s\\/.*\\.yaml";
    private static final String YMAL_REGEX = ".yaml";
    private static final String FILE_PROTOCOL = "file";
    private static final String JAR_PROTOCOL = "jar";
    /**
     * @param filePath  yaml配置文件目录
     * @return
     */
    public static List<RegexBean> getPatternList(String filePath) {
        Yaml yaml = new Yaml();
        List<RegexBean> patterns = new ArrayList<RegexBean>();
        
        List<String> fileNames = null;
        try {
            fileNames = getFileNames(filePath);
        } catch (IOException e1) {
            logger.error("get yaml file name error", e1);
            return patterns;
        }
        for (String fileName : fileNames) {
            InputStream is = null;
            try {
                is = ReadYaml.class.getResourceAsStream(fileName);
                RegexBean rbc = yaml.loadAs(is, RegexBean.class);
                patterns.add(rbc);
            } catch (Exception e) {
                logger.error("read yaml file error", e);
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        logger.error("close is error",e);
                    }
                }
            }
            
        }
        return patterns;
    }
    
    /**
     * 获取所有的文件名
     * @param filePath
     * @return
     * @throws IOException
     */
    private static List<String> getFileNames(String filePath) throws IOException {
        List<String> fileNames = new ArrayList<String>();
        URL url = ReadYaml.class.getClassLoader().getResource(filePath);
        //如果是直接运行,则使用file的方式读取yaml配置的文件名
        if (FILE_PROTOCOL.equals(url.getProtocol())) {
            File[] files = new File(url.getPath()).listFiles();
            for (File file : files) {
                if(file.getName().endsWith(YMAL_REGEX)){
                    fileNames.add("/"+filePath + "/" + file.getName());
                }
            }
        } else if (JAR_PROTOCOL.equals(url.getProtocol())) {//打成jar包的读取目录方式与直接读目录不同，所以使用以下方式
            String regex = String.format(PATTERN_REGEX, filePath);
            JarURLConnection jarURLConnection = (JarURLConnection) url
                    .openConnection();
            JarFile jarFile = jarURLConnection.getJarFile();
            Enumeration<JarEntry> entrys = jarFile.entries();
            while (entrys.hasMoreElements()) {
                JarEntry yamlEntry = entrys.nextElement();
                if (yamlEntry.getName().matches(regex)) {
                    fileNames.add("/"+yamlEntry.getName());
                }
            }
        }
        return fileNames;
    }
}
