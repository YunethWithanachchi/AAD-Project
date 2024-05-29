package lk.ijse.Travel_Planning_System.HotelServices.repository;

import lk.ijse.Travel_Planning_System.HotelServices.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {
}
