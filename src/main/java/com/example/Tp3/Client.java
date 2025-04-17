package com.example.Tp3;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue

    private long id;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String nom;

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public long getId() {
        return id;
    }

    private int age ;

}
