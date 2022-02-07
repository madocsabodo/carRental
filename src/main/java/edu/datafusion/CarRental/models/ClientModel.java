package edu.datafusion.CarRental.models;

import java.time.LocalDate;

public class ClientModel {
    private Long id;
    private String name;
    private String insuranceNumber;
    private LocalDate dateOfBirth;
    private int loyalityPoints;
    private int addressId;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

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


    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", insurance_number=" + insuranceNumber + ", date_of_birth="
                + dateOfBirth + ", loyality_points=" + loyalityPoints + "]";
    }


}
