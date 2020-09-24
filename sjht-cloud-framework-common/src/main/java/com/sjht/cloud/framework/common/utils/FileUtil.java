package com.sjht.cloud.framework.common.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.stream.Collectors;

/**
 * ***************************************************
 *
 * @ClassName FileUtil
 * @Description 文件工具类
 * @Author maojianyun
 * @Date 2020/1/3 9:42
 * @Version V1.0
 * ****************************************************
 **/
public class FileUtil {
    /**
     * 读取文件类内容
     *
     * @param fileName
     * @return
     */
    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static String readResourcesFileContent(String fileName) {
        Resource resource = new ClassPathResource(fileName);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream());
            BufferedReader br = new BufferedReader(inputStreamReader);
            return br.lines().collect(Collectors.joining("\n"));
        } catch (IOException ioe) {
            return null;
        } finally {
            try {
                if (resource != null) {
                    resource.getInputStream().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    public static String writeResourcesFileContent(String fileName, String value, boolean isAdditional) {
        Resource resource = new ClassPathResource(fileName);
        FileOutputStream fos = null;
        try {
            byte[] data = value.getBytes();
            fos = new FileOutputStream(resource.getFile(), isAdditional);
            fos.write(data);
            InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream());
            BufferedReader br = new BufferedReader(inputStreamReader);
            return br.lines().collect(Collectors.joining("\n"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (resource != null) {
                    resource.getInputStream().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
