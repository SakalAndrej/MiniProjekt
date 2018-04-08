package model;

import javax.persistence.*;

@Entity
@Table(name = "ADRESS")
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String country;
    private String additionalAdress;

    public Address(String street, String city, String country, String additionalAdress) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.additionalAdress = additionalAdress;
    }

    public Address() {
    }

    //region Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdditionalAdress() {
        return additionalAdress;
    }

    public void setAdditionalAdress(String additionalAdress) {
        this.additionalAdress = additionalAdress;
    }


    //endregion
}
