package lk.ijse.Travel_Planning_System.HotelServices.controller;

import jakarta.validation.Valid;
import lk.ijse.Travel_Planning_System.HotelServices.dto.HotelDTO;
import lk.ijse.Travel_Planning_System.HotelServices.service.HotelService;
import lk.ijse.Travel_Planning_System.HotelServices.util.ResponseUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@CrossOrigin("*")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveHotel(@Valid @RequestPart String hotelName,
                                  @RequestPart String location,
                                  @RequestPart String category,
                                  @RequestPart String starRate,
                                  @RequestPart String email,
                                  @RequestPart String phone,
                                  @RequestPart String is_pet_allowed,
                                  @RequestPart String cancellation,
                                  @RequestPart int hotel_fee,
                                  @RequestPart String remark,
                                  @RequestPart byte[] hotelImg) {

        HotelDTO hotelDTO = new HotelDTO();

        hotelDTO.setHotelName(hotelName);
        hotelDTO.setLocation(location);
        hotelDTO.setCategory(category);
        hotelDTO.setStarRate(starRate);
        hotelDTO.setEmail(email);
        hotelDTO.setPhone(phone);
        hotelDTO.setIs_pet_allowed(is_pet_allowed);
        hotelDTO.setCancellation(cancellation);
        hotelDTO.setHotel_fee(hotel_fee);
        hotelDTO.setRemark(remark);
        hotelDTO.setHotelImg(hotelImg);

        hotelService.saveHotel(hotelDTO);

        return new ResponseUtil(200, "Save Success", null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllHotel(){

//        List<VehicleDto> allVehicle = vehicleService.getAllVehicle();
        return new ResponseUtil(200,"Get All", hotelService.getAllHotels());
    }
}
