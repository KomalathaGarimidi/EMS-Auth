package com.authorization.ems.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEmp {
//    private Long id;
    private String username;
    private String password;
    private String email;

}
