package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import entity.AbstractEntity;

import java.io.Serializable;


@CqlName("sitters_id")
@Entity

public class Sitter extends AbstractEntity {

    @PartitionKey
    @CqlName("sitter_id")
    private String sitter_id;

    @CqlName("firstName")
    private String firstName;

    @CqlName("lastName")
    private String lastName;

    @CqlName("basePrice")
    private double basePrice;

    @CqlName("skill")
    private String skill;

    @CqlName("minAge")
    private Integer minAge;

    @CqlName("available")
    private boolean available;


    public enum SitterType implements Serializable {
        ACADEMIC("Academic"),
        HOUSEKEEPER("Housekeeper");


        @CqlName("typeInfo")
        private String typeInfo;

        SitterType(String typeInfo) {
            this.typeInfo = typeInfo;
        }

        public String getTypeInfo() {
            return typeInfo;
        }
    }

    @CqlName("sitterType")
    private String sitterType = SitterType.ACADEMIC.typeInfo;

    public Sitter(String sitter_id, String firstName, String lastName, double basePrice, String skill, Integer minAge, boolean available, String sitterType) {
        this.sitter_id = sitter_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.basePrice = basePrice;
        this.skill = skill;
        this.minAge = minAge;
        this.available = available;
        this.sitterType = sitterType;
    }

    public Sitter(String sitter_id, String firstName, String lastName, String skill, Integer minAge) {
        this.sitter_id = sitter_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.basePrice = basePrice;
        this.skill = skill;
        this.minAge = minAge;
    }

    public Sitter() {
    }

    public String getSitter_id() {
        return sitter_id;
    }

    public void setSitter_id(String sitter_id) {
        this.sitter_id = sitter_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getSitterType() {
        return sitterType;
    }

    public void setSitterType(String sitterType) {
        this.sitterType = sitterType;
    }
}
