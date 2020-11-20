package com.xyx.demo;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.rmi.runtime.Log;

@SpringBootApplication
@MapperScan("com.xyx.demo.mapper")
@Log4j2
public class MpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpDemoApplication.class, args);
        log.info("项目正常启动");
    }

}
