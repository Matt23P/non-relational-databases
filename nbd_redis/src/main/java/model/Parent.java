package model;

import entity.AbstractEntity;
import entity.UniqueId;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class Parent extends AbstractEntity {
    @JsonbCreator
    public Parent(
            @JsonbProperty("_id") UniqueId entityId,
            @JsonbProperty("name") String name,
            @JsonbProperty("address") String address,
            @JsonbProperty("phone_number") String phoneNumber,
            @JsonbProperty("child_age") Integer childAge) {
        super(entityId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.childAge = childAge;
    }

    public Parent(String name, String address, String phoneNumber, Integer childAge) {
        super(new UniqueId());
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.childAge = childAge;
    }

    @JsonbProperty("name")
    private String name;
    @JsonbProperty("address")
    private String address;
    @JsonbProperty("phone_number")
    private String phoneNumber;
    @JsonbProperty("child_age")
    private Integer childAge;
}
