package fpt.ad09.blood_management.service;

import java.util.List;

import fpt.ad09.blood_management.common.MyUserDetails;
import fpt.ad09.blood_management.model.User;
import fpt.ad09.blood_management.repository.RoleRepository;
import fpt.ad09.blood_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository	roleRepository;

    @Autowired

    public MyUserDetailsService(UserRepository userRepository, RoleRepository userRolesRepository) {

        this.userRepository = userRepository;

        this.roleRepository = userRolesRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        } else {
            List<String> userRoles = roleRepository.findRoleByUsername(username);
            return new MyUserDetails(user, userRoles);

        }

    }

}

