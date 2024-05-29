package lk.ijse.Travel_Planning_System.AdminServices.util;

import lk.ijse.Travel_Planning_System.AdminServices.dto.AdminDTO;
import lk.ijse.Travel_Planning_System.AdminServices.entity.Admin;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DataTypeConversion {

    private final ModelMapper modelMapper;

    DataTypeConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AdminDTO getAdminDTO(Admin admin) {
        return modelMapper.map(admin, AdminDTO.class);
    }

    public Admin getAdminEntity(AdminDTO adminDTO) {
        return modelMapper.map(adminDTO, Admin.class);
    }
}
