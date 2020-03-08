package cn.fluoxetine.frontdesk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@MapperScan(basePackages = "cn.fluoxetine.frontdesk.dao")
@SpringBootApplication
@EnableJms
public class FrontdeskApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontdeskApplication.class, args);
    }

}
