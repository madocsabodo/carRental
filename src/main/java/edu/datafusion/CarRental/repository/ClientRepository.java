package edu.datafusion.CarRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

/**
 * Repository for Client with Spring Data.
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientBE, Long>, ClientHibernateRepository{
}