package edu.datafusion.CarRental.repository;

import java.util.List;

public interface ClientHibernateRepository {
    List<ClientBE> findClientsInLoyalityPointInterval(int min, int max);
}
