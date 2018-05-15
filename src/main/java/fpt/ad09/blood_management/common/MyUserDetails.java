package fpt.ad09.blood_management.common;

import java.util.Collection;
import java.util.List;

import fpt.ad09.blood_management.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;


public class MyUserDetails extends User implements UserDetails {

    private static final long	serialVersionUID	= 1L;

    private List<String>			userRoles;

    public MyUserDetails(User user, List<String> userRoles) {
        super(user);
        this.userRoles = userRoles;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);

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

    @Override
    public String getUsername() {
        return super.getUsername();
    }

}
