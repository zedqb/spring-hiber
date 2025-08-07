package hiber.dao;

import hiber.model.Car;


public interface CarDao {

    void save(Car car);

    void add(Car car);
}
