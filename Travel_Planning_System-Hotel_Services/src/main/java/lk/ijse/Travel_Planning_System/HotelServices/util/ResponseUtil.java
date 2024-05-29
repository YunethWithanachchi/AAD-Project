package lk.ijse.Travel_Planning_System.HotelServices.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseUtil {

    private Integer code;
    private String message;
    private Object data;
}
