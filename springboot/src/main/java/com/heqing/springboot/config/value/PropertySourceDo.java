package com.heqing.springboot.config.value;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author heqing
 *
 * //@PropertySource("classpath:person.properties")
 */
@Configuration
@PropertySource(value="classpath:person.yml",encoding="utf-8")
@Data
@ToString
public class PropertySourceDo implements Serializable {

    @Value("${testLong}")
    private Long testLong;

    @Value("${testString}")
    private String testString;

    @Value("#{new java.text.SimpleDateFormat(\"yyyyMMdd\").parse(\"${testDate}\")}")
    private Date testDate;

    @Value("${testBoolean}")
    private Boolean testBoolean;

    @Value("${testJson}")
    private String testJson;

    @Value("#{'${testArray}'.split(',')}")
    private String[] testArray;

    @Value("#{'${testList}'.split(',')}")
    private List<String> testList;

    @Value("#{${testMap}}")
    private Map<String, Object> testMap;

    private Address address;

    @Value("${testEnum}")
    private PersonEnum testEnum;

    @Bean(value = "address")
    @Scope("singleton")
    public Address getAddress() {
        return new Address();
    }
}
