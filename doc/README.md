### Idea
* 通过Fiddler工具抓取请求（登陆及办理进京证）
* 分析相关请求，通过HttpClient模拟实现相关请求
* 单个流程跑通后，考虑实现多用户，定时轮询执行
* 提供用户注册界面（手机号，邮箱），邮件通知办理信息

### 获取app版本
```java
com.gjh6.car.appclient.AppClientUtil.getInstance().checksoft();

```


### 登录逻辑
* 验证码采用的是“网易云-易盾”，相关算法参考官方手册：http://support.dun.163.com/captcha/api/#_1
* 如果是首次登录需要输入手机验证码
* 第一版本暂时跳过“模拟登录”环节，后续看情况实现模拟登录

### 获取车辆列表(原生组件)
```javascript
https://bjjj.zhongchebaolian.com/industryguild_mobile_standard_self2.1.2/mobile/standard/getusercarlist?
appkey=111&
sn=1111&
userid=2222&
timestamp=2017-12-14%2021:34:29&
platform=02
&sign=aaNVCC0010b0fdaf3819a5687351d0fda77a6f25b9080cd9e6
```

### 签名算法
* 采用阿里聚安全（https://jaq-doc.alibaba.com/docs/doc.htm?spm=a313e.7629140.0.0.KnvMZs&treeId=243&articleId=105581&docType=1#s3）
* 需要搞明白阿里的sdk，还要拿到密钥，才能实现签名
* 放弃！！！


### 申请进京证（嵌套H5页面）
![进京证提交表单](https://github.com/gongjunhao/car-bjpermit/blob/master/doc/usefull/1.png)
* 有时间研究下






