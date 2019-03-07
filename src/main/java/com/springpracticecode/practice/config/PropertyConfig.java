package com.springpracticecode.practice.config;

import com.springpracticecode.practice.examplebeans.FakeDatasource;
import com.springpracticecode.practice.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {
    @Autowired
    Environment env;

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
    fakeDatasource.setUser(env.getProperty("USERNAME"));
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

@Bean
public static PropertySourcesPlaceholderConfigurer properties(){
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer=new PropertySourcesPlaceholderConfigurer();
    return propertySourcesPlaceholderConfigurer;
}


}
