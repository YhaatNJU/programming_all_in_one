package com.yha.demos.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author www
 * @Description: 实用HttpURLConnection下载文件示例
 * @create 2017/10/10
 */
public class FileDownloadDemo {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://127.0.0.1:8080/jeesite101/mobile/file/download");

        URLConnection connection = url.openConnection();

        HttpURLConnection httpConnection = (HttpURLConnection) connection;
        httpConnection.setRequestMethod("POST");

        String fullName = "E:\\\\idea_workspace\\\\jeesite101\\\\target\\\\jeesite-master\\\\userfiles\\\\50af25938d8e4321a6d080a178edbe2a\\\\files" +
                "\\\\consult\\\\consult\\\\2017\\\\10\\\\对比.xlsx";


        //httpConnection.setRequestProperty("fullName", fullName);
        //httpConnection.setRequestProperty("Content-Type", "application/Text; charset=UTF-8");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("fullName=").append(fullName);
        httpConnection.setDoInput(true);
        httpConnection.setDoOutput(true);
        httpConnection.getOutputStream().write(stringBuffer.toString().getBytes());

        httpConnection.connect();

        System.out.println(httpConnection.getResponseMessage());

        InputStream is = httpConnection.getInputStream();

        String[] temps = fullName.split("\\\\");


        File file = new File(temps[temps.length - 1]);
        System.out.println(temps[temps.length - 1]);
        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file, false);
        byte[] buffer = new byte[1024];
        int i = is.read(buffer);
        while (i > 0) {
            fos.write(buffer, 0, i);
            i = is.read(buffer);
        }

        fos.close();
        is.close();

    }

}