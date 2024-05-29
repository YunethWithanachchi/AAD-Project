package lk.ijse.Travel_Planning_System.HotelServices.dto;

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
public class HotelDTO implements Serializable {

    @Null(message = "Admin ID will auto generate")
    private Integer hotelID;
    @NotNull(message = "hotelName Cannot be empty")
    private String hotelName;
    @NotNull(message = "location Cannot be empty")
    private String location;
    @NotNull(message = "category Cannot be empty")
    private String category;
    @NotNull(message = "starRate Cannot be empty")
    private String starRate;
    @NotNull(message = "Email Cannot be empty")
    @Email
    private String email;
    @NotNull(message = "phone Cannot be empty")
    private String phone;
    @NotNull(message = "is_pet_allowed Cannot be empty")
    private String is_pet_allowed;
    @NotNull(message = "cancellation Cannot be empty")
    private String cancellation;
    @NotNull(message = "hotel_fee Cannot be empty")
    private int hotel_fee;
    private String remark;
    private byte[] hotelImg;
}
