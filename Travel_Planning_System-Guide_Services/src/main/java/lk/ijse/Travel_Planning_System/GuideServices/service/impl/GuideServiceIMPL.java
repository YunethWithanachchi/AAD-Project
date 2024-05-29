package lk.ijse.Travel_Planning_System.GuideServices.service.impl;

import lk.ijse.Travel_Planning_System.GuideServices.dto.GuideDTO;
import lk.ijse.Travel_Planning_System.GuideServices.entity.Guide;
import lk.ijse.Travel_Planning_System.GuideServices.repository.GuideRepo;
import lk.ijse.Travel_Planning_System.GuideServices.service.GuideService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuideServiceIMPL implements GuideService {

    @Autowired
    GuideRepo guideRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveGuide(GuideDTO guideDTO) {

        Guide guide = mapper.map(guideDTO, Guide.class);
        guideRepo.save(guide);
    }

    @Override
    public List<GuideDTO> getAllGuide() {
        return mapper.map(guideRepo.findAll(), new TypeToken<List<GuideDTO>>() {
        }.getType());
    }
}
