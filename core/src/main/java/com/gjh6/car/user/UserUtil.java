package com.gjh6.car.user;

import com.alibaba.fastjson.JSONObject;
import com.gjh6.car.utils.HttpClientUtils;
import org.apache.commons.io.FileUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UserUtil {
    private static String getusercarlistApi = "";

    //使用volatile关键字保其可见性
    volatile private static UserUtil instance = null;

    private UserUtil(){
        try {
            Properties prop = new Properties();
            FileInputStream in = new FileInputStream(FileUtils.toFile(UserUtil.class.getResource("/car/bjjjapis.properties")));
            prop.load(in);
            getusercarlistApi = prop.getProperty("bjjj.mobile.getusercarlist");
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserUtil getInstance() {
        try {
            if(instance != null){//懒汉式

            }else{
                //创建实例之前可能会有一些准备性的耗时工作
                Thread.sleep(300);
                synchronized (UserUtil.class) {
                    if(instance == null){//二次检查
                        instance = new UserUtil();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public JSONObject getCarList() throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("appkey", "0791682354");
        params.put("sn", "11a2efc70c57c340d1b5489c51da26bb");
        params.put("userid", "EA1F449B54724E7AB2E1D941BF6AD4A0");
        params.put("timestamp", "2017-12-14 21:34:29");
        params.put("platform", "02");
        params.put("sign", "aaNVCC0010b0fdaf3819a5687351d0fda77a6f25b9080cd9e6");
        String response =  HttpClientUtils.getInstance().get(getusercarlistApi, params);
        return JSONObject.parseObject(response);
    }
}

