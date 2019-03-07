package com.springpracticecode.practice;

import com.springpracticecode.practice.examplebeans.FakeDatasource;
import com.springpracticecode.practice.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(PracticeApplication.class, args);
        FakeDatasource fakeDatasource = (FakeDatasource) ctx.getBean(FakeDatasource.class);
        System.out.println(fakeDatasource.getUser());

        FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
        System.out.println(fakeJmsBroker.getUsername());
    }

}
