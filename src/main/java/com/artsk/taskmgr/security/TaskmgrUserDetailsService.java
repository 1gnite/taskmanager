package com.artsk.taskmgr.security;

import com.artsk.taskmgr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1gnite.
 */
public class TaskmgrUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public TaskmgrUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.artsk.taskmgr.entity.User user = userService.getByLogin(login);
        List<GrantedAuthority> authorities = createAuthorities(user.getRole());
        return buildUser(user, authorities);
    }

    private List<GrantedAuthority> createAuthorities(UserRole role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (role == UserRole.ADMIN) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if (role == UserRole.USER) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }

    private User buildUser(com.artsk.taskmgr.entity.User user, List<GrantedAuthority> authorities) {
        return new User(user.getLogin(), user.getPassword(), true, true, true, true, authorities);
    }
}
