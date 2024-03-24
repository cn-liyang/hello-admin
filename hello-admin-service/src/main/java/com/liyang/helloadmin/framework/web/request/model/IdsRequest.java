package com.liyang.helloadmin.framework.web.request.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Collection;
import lombok.Data;

/**
 * @author cn-liyang
 */
@Data
public class IdsRequest {

    @NotEmpty
    private Collection<@Valid ? extends Serializable> ids;
}
