package lk.ijse.Travel_Planning_System.UsersServices.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
    String message;
    Boolean status;
    Object data;

}
