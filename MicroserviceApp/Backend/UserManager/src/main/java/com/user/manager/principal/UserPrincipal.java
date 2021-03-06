package com.user.manager.principal;

import com.user.manager.model.Permission;
import com.user.manager.model.Role;
import com.user.manager.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@AllArgsConstructor
public class UserPrincipal implements UserDetails {

    //DECORATOR PATTERN
    private User user;

    @Transactional
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        for(Role r: this.user.getRoles()){
            for(Permission p:r.getPermissions()){
                GrantedAuthority authority=new SimpleGrantedAuthority("PERMISSION_"+p.getName());
                grantedAuthorities.add(authority);
            }
        }
//        this.user.getRoles().forEach(role -> role.getPermissions().forEach(p->{
//            GrantedAuthority authority=new SimpleGrantedAuthority(p.getName());
//            grantedAuthorities.add(authority);
//        }));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !(user.isBanned() || user.isRemoved());
    }
}
