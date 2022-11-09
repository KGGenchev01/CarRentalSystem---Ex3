package shop.carshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.carshop.model.Car;

import java.util.Optional;

public interface CarRepo extends JpaRepository<Car, Long> {
    void deleteCarById(Long id);

    Optional<Car> findCarById(Long id);
}
