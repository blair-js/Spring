package com.spring.demospringioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    /*@Autowired
    MessageSource messageSource;*/

    @Autowired
    ApplicationEventPublisher publishEvent;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*while(true){
            //messageSource 인터페이스가 제공하는 메소드 getMessage()
            //greeting이라는 key의 값으로 jisu를 전달 => prooerties 파일의 {0} 부분에 들어가게 된다.
            System.out.println(messageSource.getMessage("greeting", new String[]{"jisu"}, Locale.KOREA));
            System.out.println(messageSource.getMessage("greeting", new String[]{"jisu"}, Locale.getDefault()));
            Thread.sleep(1000);
        }*/


        publishEvent.publishEvent(new MyEvent(this, 100));

    }
}
