package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Parent")
@Access(AccessType.FIELD)
public class Parent extends AbstractEntity{
    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Parent_ID")
    private Long parentId;

    @Column(name = "Phone Number")
    private String phoneNumber;

    public Parent(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    protected Parent(){

    }
}
