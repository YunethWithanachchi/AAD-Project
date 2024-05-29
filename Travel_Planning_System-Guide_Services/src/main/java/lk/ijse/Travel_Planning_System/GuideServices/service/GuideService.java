package lk.ijse.Travel_Planning_System.GuideServices.service;

import lk.ijse.Travel_Planning_System.GuideServices.dto.GuideDTO;

import java.util.List;

public interface GuideService {
    void saveGuide(GuideDTO guideDTO);
    List<GuideDTO> getAllGuide();
}
