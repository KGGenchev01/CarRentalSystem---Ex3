package shop.carshop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.carshop.model.Car;
import shop.carshop.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarResource {
    private final CarService carService;

    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.findAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) {
        Car car = carService.findCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car newCar = carService.addCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        Car updateCar = carService.updateCar(car);
        return new ResponseEntity<>(updateCar, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/rent/{id}")
    public ResponseEntity<Void> rentCar(@PathVariable("id") Long id) {
        carService.rentCar(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/available/{id}")
    public ResponseEntity<Boolean> getAvailability(@PathVariable("id") Long id) {
        return new ResponseEntity<>(carService.availability(id), HttpStatus.OK);
    }
}
