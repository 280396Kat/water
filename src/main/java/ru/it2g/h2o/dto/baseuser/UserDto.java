package ru.it2g.h2o.dto.baseuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {


    private String username;

    private String password;

    private String phoneNumber;

    private String mail;

    private String roles;
}
