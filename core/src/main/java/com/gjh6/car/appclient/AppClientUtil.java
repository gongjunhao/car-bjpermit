package com.gjh6.car.appclient;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;

public class AppClientUtil {
    //使用volatile关键字保其可见性
    volatile private static AppClientUtil instance = null;

    private AppClientUtil(){}

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
    public JSONObject checksoft() {

        return null;
    }
}
