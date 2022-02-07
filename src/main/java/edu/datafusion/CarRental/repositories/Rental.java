package edu.datafusion.CarRental.repositories;

import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


//many to one kapcsolat
@Entity
@Table(name = "rental")
public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "car_id")
    private Long carId;

    @Column(name = "rental_start_date")
    private LocalDate rentalStartDate;

    @Column(name = "rented_hours")
    private int rentedHours;

    @Column(name = "was_returned")
    private boolean wasReturned;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, insertable = false, updatable = false)
    private Client client;

    public Rental(int id, Long clientId, Long carId) {
        this.id = id;
        this.clientId = clientId;
        this.carId = carId;
    }

    public Rental() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public LocalDate getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(LocalDate rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public int getRentedHours() {
        return rentedHours;
    }

    public void setRentedHours(int rentedHours) {
        this.rentedHours = rentedHours;
    }

    public boolean isWasReturned() {
        return wasReturned;
    }

    public void setWasReturned(boolean wasReturned) {
        this.wasReturned = wasReturned;
    }
}
