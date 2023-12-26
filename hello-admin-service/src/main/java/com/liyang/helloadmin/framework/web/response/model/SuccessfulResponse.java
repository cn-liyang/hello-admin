package com.liyang.helloadmin.framework.web.response.model;

import com.liyang.helloadmin.framework.web.response.ResponseCode;

/**
 * @author cn-liyang
 */
public class SuccessfulResponse extends BaseResponse<Object> {

    public SuccessfulResponse(Object data) {
        super(ResponseCode.SUCCESS.name(), ResponseCode.SUCCESS.name().toLowerCase(), data);
    }

    public SuccessfulResponse() {
        this(null);
    }
}
