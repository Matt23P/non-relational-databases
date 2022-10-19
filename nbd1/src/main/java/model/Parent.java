package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Parent")
public class Parent {
    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Id
    @Column(name = "Phone number")
    private String phoneNumber;

    public Parent(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    protected Parent(){

    }
}
