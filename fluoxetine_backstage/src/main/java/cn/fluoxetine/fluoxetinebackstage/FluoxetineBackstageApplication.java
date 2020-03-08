package cn.fluoxetine.fluoxetinebackstage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "cn.fluoxetine.fluoxetinebackstage.mapper")
@SpringBootApplication
public class FluoxetineBackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(FluoxetineBackstageApplication.class, args);
    }

}
