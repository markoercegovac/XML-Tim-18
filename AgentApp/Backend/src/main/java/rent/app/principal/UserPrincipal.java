package rent.app.principal;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rent.app.model.Client;
import rent.app.model.security.Permission;
import rent.app.model.security.Role;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserPrincipal  implements UserDetails {



    //DECORATOR PATTERN
    private Client user;

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
        System.out.println("Preuzeo:"  + this.user.getPassword() + this.getUsername());
        return this.user.getPassword();
    }

    @Override
    public String getUsername()
    {
        return this.user.getUsername();
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
        return true;
    }
}
