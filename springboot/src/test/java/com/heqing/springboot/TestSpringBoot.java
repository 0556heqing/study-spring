package com.heqing.springboot;

import com.heqing.springboot.config.prefix.PropertiesPrefixDo;
import com.heqing.springboot.config.value.PropertySourceDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author heqing
 * @date 2021/11/15 19:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSpringBoot {

    private  final Logger log = LoggerFactory.getLogger(TestSpringBoot.class);

    @Autowired
    PropertySourceDo propertySourceDo;

    @Test
    public void testPropertySource() {
        log.info("PropertySource --> {}", propertySourceDo);
    }


    @Autowired
    PropertiesPrefixDo propertiesPrefixDo;

    @Test
    public void testPropertiesPrefix() {
        log.info("PropertiesPrefix --> {}", propertiesPrefixDo);
    }
}
