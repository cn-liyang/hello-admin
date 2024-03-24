package com.liyang.helloadmin.project.entry.service;

import com.liyang.helloadmin.framework.crypto.model.AesPair;
import com.liyang.helloadmin.framework.crypto.util.AesUtil;
import com.liyang.helloadmin.framework.security.util.UserDetailsUtil;
import com.liyang.helloadmin.project.entry.controller.model.MenuTree;
import com.liyang.helloadmin.project.entry.controller.model.UserInfo;
import com.liyang.helloadmin.project.entry.util.MenuTreeUtil;
import com.liyang.helloadmin.project.entry.util.UserInfoUtil;
import com.liyang.helloadmin.project.system.util.UserEntityUtil;
import java.util.List;
import lombok.val;
import org.springframework.stereotype.Service;

/**
 * @author cn-liyang
 */
@Service
public class MainService {

    public AesPair getAesPairBody() {
        return AesUtil.getAesPair();
    }

    public UserInfo getUserInfoBody() {
        val entity = UserDetailsUtil.getUserInfoEntity();
        return UserInfoUtil.reduceEntity(entity);
    }

    public List<MenuTree> getMenuTreesBody() {
        val entities = UserEntityUtil.getPermTrees();
        return MenuTreeUtil.recurReduceEntities(entities);
    }
}
