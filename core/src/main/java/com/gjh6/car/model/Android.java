package com.gjh6.car.model;

import lombok.Data;

@Data
public class Android {
    /*当前版本*/
    private String curver;
    /*平台*/
    private String platform;
    /*手机品牌*/
    private String brand;
    /*制式*/
    private String model;
    /*区域*/
    private String areacode;
    /*软件key*/
    private String softkey;
}
