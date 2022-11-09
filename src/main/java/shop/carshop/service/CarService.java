package shop.carshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.carshop.exception.carNotFoundException;
import shop.carshop.model.Car;
import shop.carshop.repo.CarRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class CarService {
    private final CarRepo carRepo;

    @Autowired
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Car addCar(Car car) {
        car.setCarCode(UUID.randomUUID().toString());
        return carRepo.save(car);
    }

    public List<Car> findAllCars() {
        return carRepo.findAll();
    }

    public Car updateCar(Car car) {
        return carRepo.save(car);
    }

    public Car findCarById(Long id) {
        return carRepo.findCarById(id).orElseThrow(() -> new carNotFoundException("Car by id" + id + " was not found"));
    }

    @Transactional
    public void deleteCar(Long id) {
        carRepo.deleteCarById(id);
    }
}
