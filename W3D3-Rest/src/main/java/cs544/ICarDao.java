package cs544;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarDao extends JpaRepository<Car, Integer> {
}