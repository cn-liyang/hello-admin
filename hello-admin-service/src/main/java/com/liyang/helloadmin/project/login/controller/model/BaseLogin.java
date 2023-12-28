package com.liyang.helloadmin.project.login.controller.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cn-liyang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseLogin {

    @NotBlank
    private String id;
}
