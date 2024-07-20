package org.project.pos.auth.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoRes {
    private String userId;
    private String username;
    private String email;
    private String phone;
    private String role;
    private String group;
    private String dob;
    private String pob;
}
