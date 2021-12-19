package com.akw.logbook.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UserDTO {
    private String email;
    private String password;
    private String name;
    private String surname;
}
