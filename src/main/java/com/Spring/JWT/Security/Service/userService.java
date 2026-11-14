package com.Spring.JWT.Security.Service;

import com.Spring.JWT.Security.Model.SecurityEntity;
import com.Spring.JWT.Security.Model.securityDetails;
import com.Spring.JWT.Security.Repository.SecurityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class userService implements UserDetailsService {

    @Autowired
    private SecurityRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SecurityEntity> user = repo.findByname(username);
        if (user.isEmpty()){
            System.out.println("user not found ");
            throw new UsernameNotFoundException("user not found ");
        }
        return new securityDetails(user.get());
    }
}
