package com.liyang.helloadmin.project.system.service;

import com.liyang.helloadmin.project.system.entity.UserInfoEntity;
import com.liyang.helloadmin.project.system.mapper.UserInfoMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author cn-liyang
 */
@Service
public class UserInfoService extends ServiceImpl<UserInfoMapper, UserInfoEntity> {}
