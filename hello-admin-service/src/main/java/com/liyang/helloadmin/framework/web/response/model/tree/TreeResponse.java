package com.liyang.helloadmin.framework.web.response.model.tree;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cn-liyang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeResponse {

    @NotBlank
    private String name;

    @NotBlank
    private String icon;

    @NotBlank
    private String label;

    @NotNull
    private Boolean lazy;
}
