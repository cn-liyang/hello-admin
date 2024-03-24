package com.liyang.helloadmin.project.system.controller;

import com.liyang.helloadmin.framework.web.controller.BaseController;
import com.liyang.helloadmin.project.system.constant.SystemPaths;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cn-liyang
 */
@RestController
@RequestMapping(SystemPaths.USERS)
@Validated
public class UserController extends BaseController {}
