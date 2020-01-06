package ua.kryha.service.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.kryha.service.models.State;
import ua.kryha.service.models.JUser;

import java.util.Collection;
import java.util.Collections;


public class UserDetailsImpl implements UserDetails {

    private JUser JUser;

    public UserDetailsImpl(JUser JUser) {
        this.JUser = JUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String userRole = JUser.getRole().name();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole);
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return JUser.getHashPassword();
    }

    @Override
    public String getUsername() {
        return JUser.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !JUser.getState().equals(State.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return JUser.getState().equals(State.ACTIVE);
    }

    public JUser getJUser() {
        return JUser;
    }
}
