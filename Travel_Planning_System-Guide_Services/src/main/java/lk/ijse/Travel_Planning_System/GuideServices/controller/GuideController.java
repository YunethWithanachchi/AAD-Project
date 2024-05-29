package lk.ijse.Travel_Planning_System.GuideServices.controller;

import jakarta.validation.Valid;
import lk.ijse.Travel_Planning_System.GuideServices.dto.GuideDTO;
import lk.ijse.Travel_Planning_System.GuideServices.service.GuideService;
import lk.ijse.Travel_Planning_System.GuideServices.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guide")
@CrossOrigin("*")
public class GuideController {

    @Autowired
    GuideService guideService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveGuide(@Valid @RequestPart String guideName,
                                  @RequestPart String address,
                                  @RequestPart String age,
                                  @RequestPart String gender,
                                  @RequestPart String contact,
                                  @RequestPart String experience,
                                  @RequestPart int man_day_value,
                                  @RequestPart String remark,
                                  @RequestPart byte[] guideImg,
                                  @RequestPart byte[] nicFImg,
                                  @RequestPart byte[] nicBImg,
                                  @RequestPart byte[] guideIDFImg,
                                  @RequestPart byte[] guideIDBImg) {

        GuideDTO guideDTO = new GuideDTO();

        guideDTO.setGuideName(guideName);
        guideDTO.setAddress(address);
        guideDTO.setAge(age);
        guideDTO.setGender(gender);
        guideDTO.setContact(contact);
        guideDTO.setExperience(experience);
        guideDTO.setMan_day_value(man_day_value);
        guideDTO.setRemark(remark);
        guideDTO.setGuideImg(guideImg);
        guideDTO.setNicFImg(nicFImg);
        guideDTO.setNicBImg(nicBImg);
        guideDTO.setGuideIDFImg(guideIDFImg);
        guideDTO.setGuideIDBImg(guideIDBImg);

        guideService.saveGuide(guideDTO);
        return new ResponseUtil(200,"Save Successfully",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicle(){

        return new ResponseUtil(200,"Get All",guideService.getAllGuide());
    }
}
