package model;

import com.datastax.oss.driver.api.mapper.annotations.CqlName;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import entity.AbstractEntity;
//import lombok.*;

//@Getter
//@Setter
//@Data
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode(exclude = {"name", "address", "phoneNumber", "childAge"}, callSuper = false)
@CqlName("parents_id")
@Entity
public class Parent extends AbstractEntity {

//    @NonNull
    @PartitionKey
    @CqlName("parent_id")
    private String parent_id;
//    @NonNull
    @CqlName("name")
    private String name;
//    @NonNull
    @CqlName("address")
    private String address;
//    @NonNull
    @CqlName("phoneNumber")
    private String phoneNumber;
//    @NonNull
    @CqlName("childAge")
    private Integer childAge;

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getChildAge() {
        return childAge;
    }

    public void setChildAge(Integer childAge) {
        this.childAge = childAge;
    }

    public Parent(String parent_id, String name, String address, String phoneNumber, Integer childAge) {
        this.parent_id = parent_id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.childAge = childAge;
    }

    public Parent() {
    }
}
