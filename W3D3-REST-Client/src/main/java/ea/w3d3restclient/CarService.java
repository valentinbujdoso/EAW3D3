package ea.w3d3restclient;

import java.util.List;

public interface CarService {
    public List<Car> getAll();

    public void add(CarAddDTO car);

    public Car get(int id);

    public void update(Car car);

    public void delete(int id);
}
