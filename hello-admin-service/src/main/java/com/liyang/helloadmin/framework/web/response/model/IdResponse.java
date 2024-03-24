package com.liyang.helloadmin.framework.web.response.model;

import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cn-liyang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdResponse {

    @NotBlank
    private Serializable id;
}
