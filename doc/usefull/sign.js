bridge.callHandler('isLogin', '',function(response){
    var lsLogin = response.isLogin;
    if(lsLogin == 'false'){
        bridge.callHandler('showLoginView', '');
    }else if(response.isLogin == 'true'){
        //var userId = response.userid;
        var app_id="d584542d105322";
        var app_secret ="abeed7c94b550b6946";
        var phone = response.phoneNum;
        var nick =response.deviceid;
        var openid = phone;
        var gender=0;
        var tmp = Math.round(new Date().getTime()/1000).toString();
        var timestamp = tmp.substr(0,10);
        var sign =md5(app_id+app_secret+gender+nick+phone+openid+timestamp);
        //测试
        bridge.callHandler('pushViewController', {'type':100,'url':'https://dev.quanmin110.com/h5/80/bjjj/nuoche.html?app_id='+app_id+'&phone='+phone+'&nick='+nick+'&openid='+openid+'&gender='+gender+'&timestamp='+timestamp+'&sign='+sign});
        //正式
        bridge.callHandler('pushViewController', {'type':100,'url':'https://api.quanmin110.com/h5/80/bjjj/nuoche.html?app_id='+app_id+'&phone='+phone+'&nick='+nick+'&openid='+openid+'&gender='+gender+'&timestamp='+timestamp+'&sign='+sign});
    }
});