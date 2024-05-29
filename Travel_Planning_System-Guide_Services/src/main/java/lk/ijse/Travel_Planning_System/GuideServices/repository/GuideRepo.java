package lk.ijse.Travel_Planning_System.GuideServices.repository;

import lk.ijse.Travel_Planning_System.GuideServices.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface GuideRepo extends JpaRepository<Guide, Integer> {
}
