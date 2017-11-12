package com.yha.question;

<<<<<<< HEAD
import java.util.Arrays;

/**
 * @author yha
 * @decription 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @create 2017-11-11 21:25
 **/
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {

        if (str == null)
            return null;

        String s = str.toString();
        str = null;

        char[] chars = s.toCharArray();
        int length = chars.length;
        int space = 0;
        for (char c :chars)
            if (c == ' ')
                space++;

        char[] newChars = Arrays.copyOf(chars, length + space*2);
        chars = null;

        int j = newChars.length - 1;
        for (int i = length - 1; i >= 0 && j >= 0; i--){
            if (newChars[i] == ' '){
                newChars[j] = '0';
                newChars[j-1] = '2';
                newChars[j-2] = '%';
                j -= 3;
            }else {
                newChars[j] = newChars[i];
                j--;
            }
        }

        return String.valueOf(newChars);
    }
=======
/**
 * @author yha
 * @Description 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @date 2017/11/9
 */
public class ReplaceSpace {

}
