package com.heqing.springboot.config.prefix;

import com.heqing.springboot.config.value.PersonEnum;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author heqing
 * @date 2021/7/14 15:43
 */
@ConfigurationProperties(prefix = "prefix")
@Component
@Data
@ToString
public class PropertiesPrefixDo {

    private Long testLong;

    private String testString;

    private Date testDate;

    private Boolean testBoolean;

    private String testJson;

    private String[] testArray;

    private List<Address> testList;

    private Map<String, Object> testMap;

    private Address address;

    private PersonEnum testEnum;
}
