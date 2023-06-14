package ea.w3d3restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class CarServiceProxy implements CarService {
    @Autowired
    private RestTemplate restTemplate;
    private static String carUrl = "http://localhost:8080/cars";
    private static String carIdUrl = "http://localhost:8080/cars/{id}";

    @Override
    public List<Car> getAll() {
        ResponseEntity<List<Car>> response = restTemplate.exchange(carUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Car>>() {} );
        return response.getBody();
    }

    @Override
    public void add(CarAddDTO car) {
        restTemplate.postForLocation(carUrl, car);
    }

    @Override
    public Car get(int id) {
        return restTemplate.getForObject(carIdUrl, Car.class, id);
    }

    @Override
    public void update(Car car) {
        restTemplate.put(carUrl, car);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(carIdUrl, id);
    }
}
