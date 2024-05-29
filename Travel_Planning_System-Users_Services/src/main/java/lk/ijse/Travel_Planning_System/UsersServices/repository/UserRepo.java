package lk.ijse.Travel_Planning_System.UsersServices.repository;

import lk.ijse.Travel_Planning_System.UsersServices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User save(User user);

    Optional<User> findOneByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
