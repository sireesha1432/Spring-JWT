package com.Spring.JWT.Security.Model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AuthRequest {

    private String userName;
    private String password;
}
