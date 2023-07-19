package com.example.demo.Services;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    /**
     * Checks to see if user exists: If not, throws exception
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Inside UserService");

        if (!username.equals("billy8024")){throw new UsernameNotFoundException("Not Will");}

        Set<Role> roles = new HashSet<>();

        roles.add(new Role("user"));

        return new User("billy8024", passwordEncoder.encode("password"),"coolkids@gmail.com",roles);
    }
}
