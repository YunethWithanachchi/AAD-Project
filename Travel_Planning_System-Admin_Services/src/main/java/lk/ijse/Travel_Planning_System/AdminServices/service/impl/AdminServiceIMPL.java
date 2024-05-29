package lk.ijse.Travel_Planning_System.AdminServices.service.impl;

import lk.ijse.Travel_Planning_System.AdminServices.dto.AdminDTO;
import lk.ijse.Travel_Planning_System.AdminServices.Repository.AdminDAO;
import lk.ijse.Travel_Planning_System.AdminServices.dto.AdminLoginDTO;
import lk.ijse.Travel_Planning_System.AdminServices.entity.Admin;
import lk.ijse.Travel_Planning_System.AdminServices.response.LoginResponse;
import lk.ijse.Travel_Planning_System.AdminServices.service.AdminService;
import lk.ijse.Travel_Planning_System.AdminServices.util.DataTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminServiceIMPL implements AdminService {

    @Autowired
    private DataTypeConversion dataTypeConversion;

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AdminDTO saveAdmin(AdminDTO adminDTO) {


        return dataTypeConversion.getAdminDTO(adminDAO.save(dataTypeConversion.getAdminEntity(adminDTO)));
    }

    @Override
    public LoginResponse loginAdmin(AdminLoginDTO adminLoginDTO) {

        String msg = "";
        Admin admin = adminDAO.findByAdminEmail(adminLoginDTO.getAdminEmail());

        if (admin != null) {
            String password = adminLoginDTO.getAdminPassword();
            String encodedPassword = admin.getAdminPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);

            if (isPasswordRight) {
                Optional<Admin> admin1 = adminDAO.findOneByAdminEmailAndAdminPassword(adminLoginDTO.getAdminEmail(), encodedPassword);
                if (admin1.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else  {
            return new LoginResponse("Email not Exits", false);
        }
    }
}
