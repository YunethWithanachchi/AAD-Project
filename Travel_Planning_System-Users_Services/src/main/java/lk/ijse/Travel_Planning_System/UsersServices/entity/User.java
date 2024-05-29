package lk.ijse.Travel_Planning_System.UsersServices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User implements SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String nicNo;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String age;
    private String remark;
    @Column(nullable = false)
    private String password;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] profileImg;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] nicFImg;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] nicBImg;
}
