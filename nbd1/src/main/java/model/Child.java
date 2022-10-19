package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Child")
public class Child extends Parent {
    @Column(name = "Child name")
    private String childName;

    @Column(name = "Child age")
    private int childAge;

    public Child(String name, String address, String phoneNumber, String childName, int childAge) {
        super(name, address, phoneNumber);
        this.childName = childName;
        this.childAge = childAge;
    }

    public Child(String childName, int childAge) {
        this.childName = childName;
        this.childAge = childAge;
    }

    protected Child(){

    }
}
