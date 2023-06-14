package cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class CarRestController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/cars/{id}")
    public Car get(@PathVariable int id) {
        return carService.get(id);
    }

    @PostMapping("/cars")
    public RedirectView add(@RequestBody Car car) {
        carService.add(car);
        return new RedirectView("/cars");

    }

    @PutMapping("/cars")
    public void update(@RequestBody Car car) {
        carService.update(car);
    }

    @DeleteMapping("/cars/{id}")
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }

}
