package lk.ijse.Travel_Planning_System.UsersServices.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    @Null(message = "Admin ID will auto generate")
    private Integer userID;
    @NotNull(message = "User Name Cannot be empty")
    private String userName;
    @NotNull(message = "Address Cannot be empty")
    private String address;
    @NotNull(message = "Email Cannot be empty")
    private String email;
    @NotNull(message = "NIC No Cannot be empty")
    private String nicNo;
    @NotNull(message = "Phone Cannot be empty")
    private String phone;
    @NotNull(message = "Gender Cannot be empty")
    private String gender;
    @NotNull(message = "Age Cannot be empty")
    private String age;
    private String remark;
    @NotNull(message = "Password Cannot be empty")
    private String password;
    private byte[] profileImg;
    private byte[] nicFImg;
    private byte[] nicBImg;
}
