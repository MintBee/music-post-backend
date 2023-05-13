package com.richasha.musicpostbackend.security;

import com.richasha.musicpostbackend.entity.UserEntity;
import com.richasha.musicpostbackend.repo.UserRepository;
import org.springframework.core.log.LogMessage;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsManager {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(user.getUsername(), user.getPassword());
    }

    @Override
    @Transactional
    public void createUser(UserDetails user) {
        var newEntity = new UserEntity(user.getUsername(), user.getPassword());
        userRepository.save(newEntity);
    }

    @Override
    @Transactional
    public void updateUser(UserDetails user) {
        createUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    @Transactional
    public void changePassword(String oldPassword, String newPassword) {
        var securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();
        Authentication currentUser = securityContextHolderStrategy.getContext().getAuthentication();
        if (currentUser == null) {
            throw new AccessDeniedException(
                    "Can't change password as no Authentication object found in context " + "for current user.");
        }
        String username = currentUser.getName();

        userRepository.updatePasswordByUsername(newPassword, username);
        SecurityContext context = securityContextHolderStrategy.createEmptyContext();
        securityContextHolderStrategy.setContext(context);
    }

    @Override
    @Transactional
    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }
}

