package com.liyang.helloadmin.framework.security.service;

import com.liyang.helloadmin.framework.security.constant.UserRole;
import com.liyang.helloadmin.framework.security.service.model.UserDetailsImpl;
import com.liyang.helloadmin.framework.security.util.PasswordUtil;
import lombok.AllArgsConstructor;
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

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (!StringUtils.hasText(username)) {
            throw new UsernameNotFoundException(username);
        }
        // FIXME
        if (UserRole.isAdmin(username)) {
            return new UserDetailsImpl(PasswordUtil.getAdminEncodedPassword(), username, AuthorityUtils.NO_AUTHORITIES);
        }
        if (UserRole.isGuest(username)) {
            return new UserDetailsImpl(PasswordUtil.getGuestEncodedPassword(), username, AuthorityUtils.NO_AUTHORITIES);
        }
        throw new UsernameNotFoundException(username);
    }
}
