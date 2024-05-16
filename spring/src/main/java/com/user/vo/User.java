package com.user.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
    private int id;
    private String name;
    private String password;
    private String email;
    private Timestamp joinDate;
    private String address;
    private String phone;
    private String role;
    
}