package by;

import by.services.CityService;
import by.services.InfoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            @Transactional(readOnly = true)
            public void run(String... args) throws Exception {
                ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
                ApiContextInitializer.init();
                TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
                try {
                    telegramBotsApi.registerBot(new AssistantBot(ctx.getBean(CityService.class), ctx.getBean(InfoService.class)));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
