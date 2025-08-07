package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class CarDaoImpl implements CarDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
}
