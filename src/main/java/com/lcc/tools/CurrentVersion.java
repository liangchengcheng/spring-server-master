package com.lcc.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by lcc on 2016/12/24.
 */
public class CurrentVersion {
    private String android_version;
    private String ios_version;

    public String getAndroid_version() {
        return android_version;
    }

    public void setAndroid_version(String android_version) {
        this.android_version = android_version;
    }

    public String getIos_version() {
        return ios_version;
    }

    public void setIos_version(String ios_version) {
        this.ios_version = ios_version;
    }

    public boolean writeAndroidVersion() {

        return false;
    }

    private static String getFilePath() {
        String path = CurrentVersion.class.getClass().getResource("/").getPath();
        //截取前面6个无用的字符
        path = path.substring(6, path.length());
        //将%20 换成空格 (文件夹的名称带空格的话,会在取得字符串上变成%20)
        path = path.replaceAll("%20", "");
        //查找"WEB-INF"在该字符串的位置
        int num = path.indexOf("WEB-INF");
        //截取取得
        path = path.substring(0, num + "WEB-INF".length());
        return path;
    }

    public static String readAndroidVersion() {
        String path = getFilePath() + "/android-version.txt";
        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            StringBuffer contentBuffer = new StringBuffer();
            while ((tempString = reader.readLine())!= null){
                contentBuffer.append(tempString);
            }
            reader.close();
            return contentBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean writeIosVersion(){

        return false;
    }

    public static boolean readIosVerson(){
        return false;
    }
}
