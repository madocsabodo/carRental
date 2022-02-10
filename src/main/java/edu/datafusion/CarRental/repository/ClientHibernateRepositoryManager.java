package edu.datafusion.CarRental.repository;

import edu.datafusion.CarRental.repository.entity.ClientBE;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Custom Repository for complex operations on Client.
 */
public class ClientHibernateRepositoryManager implements ClientHibernateRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<ClientBE> findClientsInLoyalityPointInterval(int min, int max) {
        return em.createNamedQuery(ClientBE.FIND_BY_LOYALTY_POINTS, ClientBE.class)
                .setParameter(ClientBE.LOYALTY_MIN, min)
                .setParameter(ClientBE.LOYALTY_MAX, max)
                .getResultList();
    }
}
