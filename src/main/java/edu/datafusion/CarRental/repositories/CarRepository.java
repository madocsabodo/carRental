package edu.datafusion.CarRental.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CarRepository {

    @PersistenceContext
    EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Car> findAll() {
        return (List<Car>) em.createNamedQuery(Car.GET_ALL_CARS).getResultList();
    }

    public Car addCar(Car car) {
        em.persist(car);
        return car;
    }

    public void deleteById(int id) {
        em.remove(em.find(Car.class, id));
    }

    public Car findCarById(int car_id) {
       return em.find(Car.class, car_id);
    }
}
