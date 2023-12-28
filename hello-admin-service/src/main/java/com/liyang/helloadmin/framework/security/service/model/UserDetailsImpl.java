package com.liyang.helloadmin.framework.security.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liyang.helloadmin.project.system.entity.UserEntity;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author cn-liyang
 */
public record UserDetailsImpl(UserEntity userEntity, Collection<? extends GrantedAuthority> authorities)
    implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !userEntity.getLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !userEntity.getExpired();
    }

    @Override
    public boolean isEnabled() {
        return userEntity.getEnabled();
    }
}
