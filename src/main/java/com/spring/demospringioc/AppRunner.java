package com.spring.demospringioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

@Component
public class AppRunner implements ApplicationRunner {

    /*@Autowired
    MessageSource messageSource;*/

    /*@Autowired
    ApplicationEventPublisher publishEvent;*/

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //매개변수로 문자열 대입
        //classpath의 my.test 텍스트 파일을 읽어온다.
        Resource resource = resourceLoader.getResource("classpath:test.txt");
        //exists() : 해당 파일의 존재여부 확인 => 당연히 우린 파일을 안만들어 놓았으므로 없다고 나올 것 //false
        //resource 디렉토리에 해당 파일을 만들고 다시 확인해보기 //true
        System.out.println(resource.exists());
        System.out.println(resource.getDescription()); //설명(어디에 있는지 간략하게 나옴) //class path resource [test.txt]
        System.out.println(Files.readString(Path.of(resource.getURI()))); //해당 파일의 내용을 읽어온다. hello spring

        /*while(true){
            //messageSource 인터페이스가 제공하는 메소드 getMessage()
            //greeting이라는 key의 값으로 jisu를 전달 => prooerties 파일의 {0} 부분에 들어가게 된다.
            System.out.println(messageSource.getMessage("greeting", new String[]{"jisu"}, Locale.KOREA));
            System.out.println(messageSource.getMessage("greeting", new String[]{"jisu"}, Locale.getDefault()));
            Thread.sleep(1000);
        }*/

        /*publishEvent.publishEvent(new MyEvent(this, 100));*/

    }
}
