package com.example.openfeigndemo;

import com.example.openfeigndemo.myannotations.ConfigEntity;
import com.example.openfeigndemo.myannotations.EnableRemoteClient;
import com.example.openfeigndemo.myfeign.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableRemoteClient
@Import({MyService.class})//接口注册，注意接口上面加@Se
//@EnableConfigurationProperties(ConfigEntity.class)
public class OpenfeignDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignDemoApplication.class, args);
    }

}
