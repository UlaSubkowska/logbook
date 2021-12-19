package com.akw.logbook.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //TODO consider if should i return User to the controller or rather UserDTO, connected to mapping issue below
    public User registerUser(UserDTO userDTO) {
        //TODO consider if coding-encoding password part should be done in backend or frontend
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);

        //TODO!!!!!!!!!! read about and put some better mapping approach
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(encodedPassword);
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());

        return userRepository.save(user);
    }
}
