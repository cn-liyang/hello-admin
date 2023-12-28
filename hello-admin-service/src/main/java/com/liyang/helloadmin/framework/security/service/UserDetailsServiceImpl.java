package com.liyang.helloadmin.framework.security.service;

import com.liyang.helloadmin.framework.security.service.model.UserDetailsImpl;
import com.liyang.helloadmin.project.system.service.UserService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author cn-liyang
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (!StringUtils.hasText(username)) {
            throw new UsernameNotFoundException(username);
        }
        val userEntityOptional = userService.getOneOptWithRelationsByUsername(username);
        if (userEntityOptional.isPresent()) {
            return new UserDetailsImpl(userEntityOptional.get(), AuthorityUtils.NO_AUTHORITIES);
        }
        throw new UsernameNotFoundException(username);
    }
}
