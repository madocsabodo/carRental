package edu.datafusion.CarRental.repositories;

import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
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
    private int loyalityPoints;

    /*
    @Column(name = "address_id")
    private int addressId;
*/
    @OneToOne(cascade = CascadeType.ALL)
    //kerdes: miert kellett az insertable meg updateable false?
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    //one to many
    @OneToMany(mappedBy = "client")
    //@JoinColumn
    private List<Rental> rentals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public LocalDate getDateOfBirth() {
        List<HashMap<String,Object>> rsList = null;

        List<Client> clients=new ArrayList<Client>();
        for (HashMap<String,Object> rs : rsList) {
            Client client = new Client();
            client.setId ((Long) rs.get("id"));
            client.setName((String) rs.get("name"));
            client.setInsuranceNumber((String) rs.get("insuranceNumber"));
            clients.add(client);
        }

        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getLoyalityPoints() {
        return loyalityPoints;
    }

    public void setLoyalityPoints(int loyalityPoints) {
        this.loyalityPoints = loyalityPoints;
    }
}
