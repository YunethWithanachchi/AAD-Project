package lk.ijse.Travel_Planning_System.UsersServices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDTO {

    private String email;
    private String password;
}
