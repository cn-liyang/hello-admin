package com.liyang.helloadmin.framework.security.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liyang.helloadmin.framework.security.constant.SecurityRole;
import com.liyang.helloadmin.project.system.entity.UserEntity;
import java.util.List;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

/**
 * @author cn-liyang
 */
public record UserDetailsImpl(UserEntity userEntity, List<? extends GrantedAuthority> authorities)
    implements UserDetails {
    @Override
    public List<? extends GrantedAuthority> getAuthorities() {
        if (CollectionUtils.isEmpty(authorities)) {
            return AuthorityUtils.NO_AUTHORITIES;
        }
        return authorities;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        if (Objects.isNull(userEntity.getPassword())) {
            return "";
        }
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        if (Objects.isNull(userEntity.getUsername())) {
            return "";
        }
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        if (Objects.isNull(userEntity.getExpiredAccount())) {
            return false;
        }
        return !userEntity.getExpiredAccount();
    }

    @Override
    public boolean isAccountNonLocked() {
        if (Objects.isNull(userEntity.getLocked())) {
            return false;
        }
        return !userEntity.getLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if (Objects.isNull(userEntity.getExpiredPassword())) {
            return false;
        }
        return !userEntity.getExpiredPassword();
    }

    @Override
    public boolean isEnabled() {
        if (Objects.isNull(userEntity.getEnabled())) {
            return false;
        }
        return userEntity.getEnabled();
    }

    public Boolean isAdmin() {
        return AuthorityUtils.authorityListToSet(authorities).stream().anyMatch(SecurityRole::isAdmin);
    }

    public Boolean isGuest() {
        return AuthorityUtils.authorityListToSet(authorities).stream().allMatch(SecurityRole::isGuest);
    }
}
