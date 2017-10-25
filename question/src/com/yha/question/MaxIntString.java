package com.yha.question;

/**
 * @author yha
 * @decription 获取一个字符串中的最大连续数字，其中RED可以消除，找不到则返回0
 * 比如124AK99中最大的数字为124,12342423ALLF2213RED124中的最大数字为2213124，不限32位整数
 * @create 2017-10-25 20:36
 **/
public class MaxIntString {

    public static final String SEPARATOR = "RED";

    public static String maxIntString(String source){

        if (source == null || source.equals(""))
            return "";

        if (source.contains(SEPARATOR)){
            String[] strings = source.split(SEPARATOR);
            source = "";
            for (String s : strings){
                if (s.equals(""))
                    continue;
                source += s;
            }
        }

        boolean find = false;
        char[] chars = source.toCharArray();
        int length = chars.length;
        String max = "";
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i < length){
            if (chars[i] >= '0' && chars[i] <= '9'){
                find = true;
                builder = new StringBuilder();
                do {
                    builder.append(chars[i]);
                    i++;
                }while (i < length && chars[i] >= '0' && chars[i] <= '9');

                if (i >= length){
                    String tempString = builder.toString();
                    if (tempString.length() > max.length()){
                        max = tempString;
                    }else if(tempString.length() == max.length()){
                        max = maxString(max, tempString);
                    }
                }
            }else {
                String tempString = builder.toString();
                if (tempString.length() > max.length()){
                    max = tempString;
                }else if(tempString.length() == max.length()){
                    max = maxString(max, tempString);
                }
                i++;
            }
        }

        if (find)
            return max;
        else
            return "0";

    }


    private static String maxString(String a, String b){

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int length = a.length();
        for (int i = 0; i < length; i++){
            if (charsA[i] > charsB[i])
                return a;
            else if (charsA[i] < charsB[i])
                return b;
        }

        return a;
    }

    public static void main(String[] args){

        System.out.println(maxIntString("adfa12342341RED123412asld12341234123"));
    }

}
