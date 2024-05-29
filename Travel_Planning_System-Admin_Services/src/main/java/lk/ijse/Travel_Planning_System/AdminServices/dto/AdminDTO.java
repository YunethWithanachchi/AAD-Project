package lk.ijse.Travel_Planning_System.AdminServices.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO implements Serializable {

    @Null(message = "Admin ID will auto generate")
    private Integer adminID;
    @NotNull(message = "Admin Name Cannot be empty")
    private String adminName;
    @NotNull(message = "Admin Email Cannot be empty")
    @Email
    private String adminEmail;
    @NotNull(message = "Admin Password Cannot be empty")
    private String adminPassword;
    private String adminIMG;
}
