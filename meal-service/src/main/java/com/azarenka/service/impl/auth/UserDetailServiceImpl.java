package com.azarenka.service.impl.auth;


import com.azarenka.domain.User;
import com.azarenka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired(required = false)
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getByEmail(username);
        if (null == user) {
            throw new UsernameNotFoundException("User Not Found with -> username or email : " + username);
        }

        return UserPrinciple.build(user);
    }
}
