package com.home.javaUtils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public static String replaceAll(String sourceString, char regex, String replacement) {
        int regexNum = 0;
        int regexIndex = 0;
        char[] replaceArray = replacement.toCharArray();

        // 查找源字符串中有多少分隔符
        char[] sourceArray = sourceString.toCharArray();
        for (char c : sourceArray) {
            if (c == regex) {
                regexNum++;
            }
        }

        // 创建新转换后的char数组，长度为源字符串长度+（替换字符串长度-分隔符长度）* 分隔符个数
        char[] newCharArray = new char[sourceArray.length + (replaceArray.length - 1) * regexNum];

        // 将旧字符串数组拷贝到新字符串数组中
        for (int i = 0; i < sourceArray.length; i++) {

            if (sourceArray[i] == regex) {
                for (int j = 0; j < replaceArray.length; j++) {
                    if (regexIndex == 0) {
                        newCharArray[i + j] = replaceArray[j];
                    } else {
                        newCharArray[i + regexIndex * (replaceArray.length - 1) + j] = replaceArray[j];
                    }
                }
                regexIndex++;
            } else {
                if (regexIndex == 0) {
                    newCharArray[i] = sourceArray[i];
                } else {
                    newCharArray[i + regexIndex * (replaceArray.length - 1)] = sourceArray[i];
                }
            }

        }
        return String.valueOf(newCharArray);
    }


    public static void main(String[] args) {

        String str = createLongStr();

        TimeReporter tr = new TimeReporter();
        tr.start();
        String result = str.replaceAll(",", "\",\"");
        tr.stop("String replaceAll");

        tr.start();
        String result1 = StringUtils.replaceAll(str, ',', "\",\"");
        tr.stop("StringUtils replaceAll");

        //System.out.println(result);
        //System.out.println(result1);
    }

    public static String createLongStr() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sb.append("abc").append(",");
        }
        return sb.toString();
    }

}
