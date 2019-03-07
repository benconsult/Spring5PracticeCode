package com.springpracticecode.practice.config;

import com.springpracticecode.practice.examplebeans.FakeDatasource;
import com.springpracticecode.practice.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {


    @Value("${ben.username}")
    public String user;

    @Value("{ben.password}")
    public String password;

    @Value("${ben.dburl}")
    public String url;
    @Value("${ben.jms.username}")
    String jmsUsername;
    @Value("${ben.jms.password}")
    String jmsPassword;
    @Value("${ben.jms.url}")
    String jmsUrl;


@Bean
public FakeDatasource fakeDatasource(){
    FakeDatasource fakeDatasource=new FakeDatasource();
    fakeDatasource.setUser(user);
    fakeDatasource.setPassword(password);
    fakeDatasource.setUrl(url);
    return fakeDatasource;
}
@Bean
public FakeJmsBroker fakeJmsBroker(){
    FakeJmsBroker fakeJmsBroker=new FakeJmsBroker();
    fakeJmsBroker.setUsername(jmsUsername);
    fakeJmsBroker.setPassword(jmsPassword);
    fakeJmsBroker.setUrl(jmsUrl);
    return fakeJmsBroker;
}




}
