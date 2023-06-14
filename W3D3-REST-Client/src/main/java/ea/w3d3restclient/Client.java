package ea.w3d3restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Client implements CommandLineRunner {
    @Autowired
    private CarServiceProxy carServiceProxy;

    @Override
    public void run(String... args) {
        //◦ make a call to whatever url you mapped getAll() on and print the result
        List<Car> result = carServiceProxy.getAll();
        System.out.println("getAll(): " + result);

        //◦ make a call to the url that you mapped add() on (giving it a new book)
        carServiceProxy.add(new CarAddDTO("make", "model", 2022, "color"));
        result = carServiceProxy.getAll();
        System.out.println("After add(): " + result);

        //◦ make a call to the url that you mapped update() on (giving it an updated version)
        Car car = result.get(0);
        car.setColor("EMPTY");
        carServiceProxy.update(car);

        result = carServiceProxy.getAll();
        System.out.println("After update(): " + result);


        // ◦ make a call to the url that you mapped delete() on (deleting one of the books)
        carServiceProxy.delete(car.getId());
        result = carServiceProxy.getAll();
        System.out.println("After delete(): " + result);

        //◦ make a call to the url that you mapped getAll() on and print the result again
        result = carServiceProxy.getAll();
        System.out.println("getAll(): " + result);

        //◦ make a call to the url that you mapped get() to check that you can get one book
        int index = result.get(0).getId();
        car = carServiceProxy.get(index);
        System.out.println("get(" + index + "): " + car);
    }
}
