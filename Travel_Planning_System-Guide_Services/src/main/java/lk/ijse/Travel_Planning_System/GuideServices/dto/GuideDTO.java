package lk.ijse.Travel_Planning_System.GuideServices.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideDTO {

    @Null(message = "Admin ID will auto generate")
    private Integer guideID;
    @NotNull(message = "guideName Cannot be empty")
    private String guideName;
    @NotNull(message = "address Cannot be empty")
    private String address;
    @NotNull(message = "age Cannot be empty")
    private String age;
    @NotNull(message = "gender Cannot be empty")
    private String gender;
    @NotNull(message = "contact Cannot be empty")
    private String contact;
    @NotNull(message = "experience Cannot be empty")
    private String experience;
    @NotNull(message = "man_day_value Cannot be empty")
    private int man_day_value;
    private String remark;
    private byte[] guideImg;
    private byte[] nicFImg;
    private byte[] nicBImg;
    private byte[] GuideIDFImg;
    private byte[] GuideIDBImg;
}
