package lk.ijse.Travel_Planning_System.UsersServices.service.impl;

import lk.ijse.Travel_Planning_System.UsersServices.dto.UserDTO;
import lk.ijse.Travel_Planning_System.UsersServices.dto.UserLoginDTO;
import lk.ijse.Travel_Planning_System.UsersServices.entity.User;
import lk.ijse.Travel_Planning_System.UsersServices.repository.UserRepo;
import lk.ijse.Travel_Planning_System.UsersServices.service.UserService;
import lk.ijse.Travel_Planning_System.UsersServices.util.DataTypeConversion;
import lk.ijse.Travel_Planning_System.UsersServices.util.Response;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIMPL implements UserService {

    @Autowired
    private DataTypeConversion dataTypeConversion;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper mapper;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return dataTypeConversion.getUserDTO(userRepo.save(dataTypeConversion.getUserEntity(userDTO)));
    }

    @Override
    public Response loginUser(UserLoginDTO userLoginDTO) {

        String msg = "";

        User user = userRepo.findByEmail(userLoginDTO.getEmail());

        if (user != null) {

            String password = userLoginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);

            if (isPasswordRight) {
                Optional<User> user1 = userRepo.findOneByEmailAndPassword(userLoginDTO.getEmail(), encodedPassword);
                if (user1.isPresent()) {
                    return new Response("Login Success", true, null);
                } else {
                    return new Response("Login Failed", false, null);
                }
            } else {
                return new Response("Password Not Match", false, null);
            }
        } else {
            return new Response("Email Not Valid", false, null);
        }

    }

    @Override
    public List<UserDTO> getAllUser() {
        return mapper.map(userRepo.findAll(), new TypeToken<List<UserDTO>>() {}.getType());
    }
}
