package com.thoughtworks.capacity.gtb.mvc.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userId;
    @NotNull(message = "username illegal")
    @Size(min=5,max = 12,message = "username illegal")
    private String username;
    @Pattern(regexp = "^[0-9a-zA-Z_]{5,12}",message = "password illegal")
    private String password;

    @Pattern(regexp = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)+", message = "email illegal")
    private String emailAddress;

}
