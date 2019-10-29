package com.kk.springsecurityjpa.service;

import com.kk.springsecurityjpa.pojo.FKRole;
import com.kk.springsecurityjpa.pojo.FKUser;
import com.kk.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        FKUser fkUser = userRepository.findByLoginName(s);
        if (fkUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        List<FKRole> roles = fkUser.getRoles();
        for (FKRole role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return new User(fkUser.getUsername(), fkUser.getPassword(), authorities);
    }
}
