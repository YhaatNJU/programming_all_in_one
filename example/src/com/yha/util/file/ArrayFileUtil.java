package com.yha.util.file;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * @author yha
 * @decription 包括一些读写数组到文件的静态方法
 * @create 2017-10-06 13:41
 **/
public class  ArrayFileUtil {

    /**
     *
     * @param data 待写入的int数组
     * @param fileName 待写入文件全限定名
     * @param append 是否是追加
     */
    public static void writeIntArray(int[] data, String fileName, boolean append){

        File file = new File(fileName);
        File fileParent = file.getParentFile();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (!fileParent.exists()){
                fileParent.mkdir();
            }
            if (!file.exists()){
                file.createNewFile();
            }
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder builder = new StringBuilder();
            for (int i : data){
                builder.append(i + "\n");
            }
            
            bufferedWriter.write(builder.toString());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            if (bufferedWriter != null){
                try {
                    bufferedWriter.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            if (fileWriter != null){
                try {
                    fileWriter.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            
        }
    }
    
    public static void main(String[] args){
        
        int[] data = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++){
            data[i] = random.nextInt(1000000000);
        }
        writeIntArray(data, "file/numbers/numbers.txt", false);
    }
    
    public static void readIntArray(int[] writeTo, String fileName){
        
        File file = new File(fileName);
        
        if (!file.exists())
            throw new Error("No such file: " + fileName);
    
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            Scanner scanner = new Scanner(br);
            int i = 0;
            String temp = null;
            while (i < writeTo.length){
                temp = br.readLine();
                if (temp == null || temp.equals(""))
                    break;
                writeTo[i] = Integer.parseInt(temp);
                i++;
                
            }
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            if (br != null){
                try {
                    br.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            if (fr != null){
                try {
                    fr.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
    }

}
