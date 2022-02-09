package edu.datafusion.CarRental.repository;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Entity class for the Client.
 */
@Entity
@Table(name = "client")
@Data
@NamedQueries(@NamedQuery(name = ClientBE.FIND_BY_LOYALTY_POINTS, query = "select c from ClientBE c where loyaltyPoints between :"
        + ClientBE.LOYALTY_MIN + " and :" + ClientBE.LOYALTY_MAX))
public class ClientBE {
    public static final String FIND_BY_LOYALTY_POINTS = "findByLoyaltyPoints";
    public static final String LOYALTY_MIN = "loyaltyMin";
    public static final String LOYALTY_MAX = "loyaltyMax";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "insurance_number")
    private String insuranceNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "loyality_points")
    private int loyaltyPoints;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressBE address;

    @OneToMany(mappedBy = "clientBE")
    private List<RentalBE> rentalBES;
}
