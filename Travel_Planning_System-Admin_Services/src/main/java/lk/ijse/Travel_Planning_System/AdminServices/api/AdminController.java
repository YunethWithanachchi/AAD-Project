package lk.ijse.Travel_Planning_System.AdminServices.api;

import jakarta.validation.Valid;
import lk.ijse.Travel_Planning_System.AdminServices.dto.AdminDTO;
import lk.ijse.Travel_Planning_System.AdminServices.dto.AdminLoginDTO;
import lk.ijse.Travel_Planning_System.AdminServices.response.LoginResponse;
import lk.ijse.Travel_Planning_System.AdminServices.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private final AdminService adminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/save")
    AdminDTO saveAdmin(@Valid
            @RequestPart("adminName") String adminName,
            @RequestPart("adminEmail") String adminEmail,
            @RequestPart("adminPassword") String adminPassword,
            @RequestPart("adminIMG") MultipartFile file, Errors errors) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("Not a valid file");
        }

        String convertedIMG;
        try {
            convertedIMG = Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (errors.hasFieldErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.getFieldErrors().get(0).getDefaultMessage());
        }

        AdminDTO adminDTO = new AdminDTO();

        adminDTO.setAdminName(adminName);
        adminDTO.setAdminEmail(adminEmail);
        adminDTO.setAdminPassword(this.passwordEncoder.encode(adminPassword));
        adminDTO.setAdminIMG(convertedIMG);

        return adminService.saveAdmin(adminDTO);
    }

    @PostMapping(path = "/adminlogin")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminLoginDTO adminLoginDTO) {

        LoginResponse loginResponse = adminService.loginAdmin(adminLoginDTO);

        return ResponseEntity.ok(loginResponse);
    }

}
