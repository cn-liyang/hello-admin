package com.liyang.helloadmin.project.login.controller.model;

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
public class CaptchaResponse extends BaseLogin {

    @NotBlank
    private String dataUrl;

    public CaptchaResponse(String id, String dataUrl) {
        super(id);
        this.dataUrl = dataUrl;
    }
}
