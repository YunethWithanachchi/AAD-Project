package lk.ijse.Travel_Planning_System.AdminServices.service;

import lk.ijse.Travel_Planning_System.AdminServices.dto.AdminDTO;
import lk.ijse.Travel_Planning_System.AdminServices.dto.AdminLoginDTO;
import lk.ijse.Travel_Planning_System.AdminServices.response.LoginResponse;

public interface AdminService {
    AdminDTO saveAdmin(AdminDTO adminDTO);

    LoginResponse loginAdmin(AdminLoginDTO adminLoginDTO);
}
