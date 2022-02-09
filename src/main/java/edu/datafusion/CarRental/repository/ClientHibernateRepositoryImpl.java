package edu.datafusion.CarRental.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Custom Repository for complex operations on Client.
 */
public class ClientHibernateRepositoryImpl implements ClientHibernateRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<ClientBE> findClientsInLoyalityPointInterval(int min, int max) {
        return em.createNamedQuery(ClientBE.FIND_BY_LOYALTY_POINTS, ClientBE.class)
                .setParameter(min,ClientBE.LOYALTY_MIN)
                .setParameter(max, ClientBE.LOYALTY_MAX)
                .getResultList();
    }
}