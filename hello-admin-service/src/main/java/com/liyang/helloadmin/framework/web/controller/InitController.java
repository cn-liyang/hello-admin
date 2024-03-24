package com.liyang.helloadmin.framework.web.controller;

import java.beans.PropertyEditor;
import java.time.LocalDateTime;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author cn-liyang
 */
public class InitController {

    @InitBinder
    private void initBinder(WebDataBinder binder, PropertyEditor localDateTimeEditor) {
        binder.registerCustomEditor(LocalDateTime.class, localDateTimeEditor);
    }
}
