package lk.ijse.Travel_Planning_System.AdminServices.Repository;

import lk.ijse.Travel_Planning_System.AdminServices.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {
    Admin save(Admin admin);

    Optional<Admin> findOneByAdminEmailAndAdminPassword(String adminEmail, String adminPassword);

    Admin findByAdminEmail(String adminEmail);
}
