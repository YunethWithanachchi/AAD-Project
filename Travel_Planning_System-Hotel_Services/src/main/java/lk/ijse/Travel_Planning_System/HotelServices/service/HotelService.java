package lk.ijse.Travel_Planning_System.HotelServices.service;

import lk.ijse.Travel_Planning_System.HotelServices.dto.HotelDTO;

import java.util.List;

public interface HotelService {

    void saveHotel(HotelDTO hotelDTO);

    List<HotelDTO> getAllHotels();
}
