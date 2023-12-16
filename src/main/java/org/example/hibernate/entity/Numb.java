package org.example.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Numb")
public class Numb {

    public Numb() {

    }

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "numb")
    private String numb;

    @Column(name = "country")
    private String country;

    public Numb(int id, String numb, String country){
        this.id = id;
        this.numb = numb;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumb() {
        return numb;
    }

    public void setNumb(String numb) {
        this.numb = numb;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return "Numb [id = " + id + ", numb = " + numb + ", country = " + country + "]";
    }
}
