package com.gjh6.car.appclient;

import com.alibaba.fastjson.JSONObject;
import com.gjh6.car.model.Android;
import com.gjh6.car.utils.HttpClientUtils;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppClientUtil {

    private static String checksoftApi = "";

    //使用volatile关键字保其可见性
    volatile private static AppClientUtil instance = null;

    private AppClientUtil(){
        try {
            Properties prop = new Properties();
            FileInputStream in = new FileInputStream(FileUtils.toFile(AppClientUtil.class.getResource("/car/bjjjapis.properties")));
            prop.load(in);
            checksoftApi = prop.getProperty("bjjj.mobile.checksoft");
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppClientUtil getInstance() {
        try {
            if(instance != null){//懒汉式

            }else{
                //创建实例之前可能会有一些准备性的耗时工作
                Thread.sleep(300);
                synchronized (AppClientUtil.class) {
                    if(instance == null){//二次检查
                        instance = new AppClientUtil();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * 检查是否为最新客户端
     * @return
     */
    public JSONObject checksoft() throws IOException {
        Android android = new Android();
        android.setCurver("21");
        android.setPlatform("android");
        android.setAreacode("all");
        android.setSoftkey("iiowner_android");
        String response = HttpClientUtils.getInstance().postJson(checksoftApi, null, android);
        return JSONObject.parseObject(response);
    }
}
