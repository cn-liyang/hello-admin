package com.liyang.helloadmin.framework.web.request.model;

import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author cn-liyang
 */
@Data
public class IdRequest {

    @NotEmpty
    private Serializable id;
}
