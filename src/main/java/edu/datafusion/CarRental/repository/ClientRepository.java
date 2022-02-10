package edu.datafusion.CarRental.repository;

import edu.datafusion.CarRental.repository.entity.ClientBE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Client with Spring Data.
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientBE, Long>, ClientHibernateRepository{
    @Query("select c from ClientBE c where c.address.city in cities")
    List<ClientBE> findByCities(List<String> cities);

}