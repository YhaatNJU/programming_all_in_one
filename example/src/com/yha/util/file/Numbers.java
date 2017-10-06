package com.yha.util.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author yha
 * @decription 包括一些读写数组到文件的静态方法
 * @create 2017-10-06 13:41
 **/
public class Numbers {

    /**
     *
     * @param data
     * @param fileName
     * @param append
     */
    public static void writeNumbers(int[] data, String fileName, boolean append){

        File file = new File(fileName);

        FileWriter fileWriter = null;
        try {
            if (!file.exists())
                file.createNewFile();
            fileWriter = new FileWriter(file, append);
            StringBuilder builder = new StringBuilder();
            for (int i : data){
                builder.append(i + "\n");
            }
            fileWriter.write(builder.toString());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            if (fileWriter != null){
                try {
                    fileWriter.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
    }

}
