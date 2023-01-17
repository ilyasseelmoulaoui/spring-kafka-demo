package me.elmoulaoui.springcloudekafkademo.services;

import me.elmoulaoui.springcloudekafkademo.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
public class PageEventService {
    @Bean
    public Consumer<PageEvent> pageEventConsumer()
    {
        return (input) -> {
            System.out.println("--------------------------");
            System.out.println(input.toString());
            System.out.println("--------------------------");
        };
    }
    @Bean
    public Supplier<PageEvent> pageEventSupplier()
    {
        return () ->  new PageEvent(Math.random() > 0.5 ? "www.elmoulaoui.com" : "www.karam.fr", Math.random() > 0.5 ? "EL MOULAOUI" : "KARAM", new Date(), new Random().nextInt(5000));
    }
}
