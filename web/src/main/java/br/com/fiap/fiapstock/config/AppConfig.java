package br.com.fiap.fiapstock.config;

import br.com.fiap.fiapstock.service.StockPriceCheck;
import br.com.fiap.fiapstock.service.StockPriceCheckImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public StockPriceCheck stockPriceCheck(){
        return new StockPriceCheckImpl();
    }

}
