package com.heqing.springboot.config.value;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author heqing
 */
@Data
@ToString
public class Address {

    @Value("${address.provice}")
    private String provice;

    @Value("${address.city}")
    private String city;

    @Value("${address.area}")
    private String area;

}
