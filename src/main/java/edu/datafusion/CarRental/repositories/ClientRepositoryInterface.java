package edu.datafusion.CarRental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ClientRepositoryInterface extends JpaRepository<Client, Long> {
}
