package edu.datafusion.CarRental.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Repository for Car with Hibernate and EntityManager.
 */
@Repository
@Transactional
public class CarRepository {

    @PersistenceContext
    EntityManager em;

    @SuppressWarnings("unchecked")
    public List<CarBE> findAll() {
        return (List<CarBE>) em.createNamedQuery(CarBE.GET_ALL_CARS).getResultList();
    }

    public CarBE addCar(CarBE car) {
        em.persist(car);
        return car;
    }

    public void deleteById(long id) {
        em.remove(em.find(CarBE.class, id));
    }

    public CarBE findCarById(int car_id) {
        return em.find(CarBE.class, car_id);
    }

}
