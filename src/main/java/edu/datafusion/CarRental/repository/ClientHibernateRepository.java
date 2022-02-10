package edu.datafusion.CarRental.repository;

import edu.datafusion.CarRental.repository.entity.ClientBE;

import java.util.List;

public interface ClientHibernateRepository {
    List<ClientBE> findClientsInLoyalityPointInterval(int min, int max);
}
