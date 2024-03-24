package com.liyang.helloadmin.project.system.service;

import com.liyang.helloadmin.project.system.entity.UserEntity;
import com.liyang.helloadmin.project.system.mapper.UserMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author cn-liyang
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {}
