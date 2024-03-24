package com.liyang.helloadmin.project.entry.controller.model;

import com.liyang.helloadmin.framework.web.response.model.IdResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author cn-liyang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LoginCode extends IdResponse {

    @NotBlank(message = "请输入验证码")
    private String code;
}
