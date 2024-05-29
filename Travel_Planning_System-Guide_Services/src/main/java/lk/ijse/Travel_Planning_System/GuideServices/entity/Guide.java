package lk.ijse.Travel_Planning_System.GuideServices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Guide implements SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer guideID;
    @Column(nullable = false)
    private String guideName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String contact;
    @Column(nullable = false)
    private String experience;
    @Column(nullable = false)
    private int man_day_value;
    private String remark;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] guideImg;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] nicFImg;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] nicBImg;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] GuideIDFImg;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] GuideIDBImg;

}
