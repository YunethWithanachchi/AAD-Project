package lk.ijse.Travel_Planning_System.HotelServices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Hotel implements SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelID;
    @Column(nullable = false)
    private String hotelName;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String starRate;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String is_pet_allowed;
    @Column(nullable = false)
    private String cancellation;
    @Column(nullable = false)
    private int hotel_fee;
    private String remark;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] hotelImg;
}
