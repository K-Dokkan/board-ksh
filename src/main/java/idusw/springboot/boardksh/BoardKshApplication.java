package idusw.springboot.boardksh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //(exclude = DataSourceAutoConfiguration.class)
public class BoardKshApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardKshApplication.class, args);
    }

}
