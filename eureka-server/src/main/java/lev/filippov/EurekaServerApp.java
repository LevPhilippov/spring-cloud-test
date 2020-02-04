package lev.filippov;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp {

//    Не берет настройку с конфиг-сервера
    @Value("${name}")
    static String name="Carl";

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp.class);
        System.out.println(name);
    }
}
