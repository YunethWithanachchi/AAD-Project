package lk.ijse.Travel_Planning_System.UsersServices.controller;

import jakarta.validation.Valid;
import lk.ijse.Travel_Planning_System.UsersServices.dto.UserDTO;
import lk.ijse.Travel_Planning_System.UsersServices.dto.UserLoginDTO;
import lk.ijse.Travel_Planning_System.UsersServices.service.UserService;
import lk.ijse.Travel_Planning_System.UsersServices.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/save")
    public Response saveUser(@Valid
                     @RequestPart String userName,
                     @RequestPart String address,
                     @RequestPart String email,
                     @RequestPart String nicNo,
                     @RequestPart String phone,
                     @RequestPart String gender,
                     @RequestPart String age,
                     @RequestPart String remark,
                     @RequestPart String password,
                     @RequestPart byte[] profileImg,
                     @RequestPart byte[] nicFImg,
                     @RequestPart byte[] nicBImg, Errors errors) {

        if (errors.hasFieldErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.getFieldErrors().get(0).getDefaultMessage());
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserName(userName);
        userDTO.setAddress(address);
        userDTO.setEmail(email);
        userDTO.setNicNo(nicNo);
        userDTO.setPhone(phone);
        userDTO.setGender(gender);
        userDTO.setAge(age);
        userDTO.setRemark(remark);
        userDTO.setPassword(this.passwordEncoder.encode(password));
        userDTO.setProfileImg(profileImg);
        userDTO.setNicFImg(nicFImg);
        userDTO.setNicBImg(nicBImg);

        userService.saveUser(userDTO);
        return new Response("Save Success", true, null);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAllUser() {
        return new Response("Get All", true, userService.getAllUser());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/userlogin", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> loginUser(@Valid @RequestBody UserLoginDTO userLoginDTO) {

        Response response = userService.loginUser(userLoginDTO);

        return ResponseEntity.ok(response);
    }

}
