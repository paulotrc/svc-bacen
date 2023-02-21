package br.paulotrc.svcbacen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SvcBacenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvcBacenApplication.class, args);
    }

}
