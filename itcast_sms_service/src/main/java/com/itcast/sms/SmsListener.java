package com.itcast.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 11699
 * @date 2020/2/5 - 17:13
 */
@Component
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @JmsListener(destination = "sms")
    public void sendSms(Map<String,String> map){
        smsUtil.send(map.get("mobile"),
                map.get("sign_name"),
                map.get("template_code"),
                map.get("param"));
    }
}
