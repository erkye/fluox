package cn.fluoxetine.frontdesk.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author 11699
 * @date 2020/2/21 - 14:10
 */
@Configuration
public class ActiveMQConfig {

    /**
     * 定义短信的消息队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("sms");
    }
}
