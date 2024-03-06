package com.sbaldass.booksapi.services;

import com.sbaldass.booksapi.domain.User;
import com.sbaldass.booksapi.domain.UserInfoDetails;
import com.sbaldass.booksapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userDetail = repository.findByName(username);

        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public User addUser(User userInfo) {
        userInfo.setName(userInfo.getName());
        userInfo.setRoles(userInfo.getRoles());
        userInfo.setEmail(userInfo.getEmail());
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return userInfo;
    }

    public List<User> usersList(){
        return repository.findAll();
    }

}
