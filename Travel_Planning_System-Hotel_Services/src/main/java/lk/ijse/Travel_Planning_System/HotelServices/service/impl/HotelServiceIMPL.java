package lk.ijse.Travel_Planning_System.HotelServices.service.impl;

import lk.ijse.Travel_Planning_System.HotelServices.dto.HotelDTO;
import lk.ijse.Travel_Planning_System.HotelServices.entity.Hotel;
import lk.ijse.Travel_Planning_System.HotelServices.repository.HotelRepo;
import lk.ijse.Travel_Planning_System.HotelServices.service.HotelService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HotelServiceIMPL implements HotelService {

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveHotel(HotelDTO hotelDTO) {
        Hotel hotel = mapper.map(hotelDTO, Hotel.class);
        hotelRepo.save(hotel);
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        return mapper.map(hotelRepo.findAll(), new TypeToken<List<HotelDTO>>() {}.getType());
    }
}
