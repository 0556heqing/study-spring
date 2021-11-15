package com.heqing.springboot.controller;

import com.heqing.springboot.controller.validator.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author heqing
 * @date 2021/7/16 18:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyReq {

    @NotBlank(message="code不能为空")
    String code;

    @Length(max=10, message="name长度不能超过10")
    String name;

    /**
     * 自定义注解
     */
    @Constant(value="1.0", message = "verson只能为1.0")
    String version;

}
