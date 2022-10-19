package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Housekeeper")
public class Housekeeper extends Sitter {

    @Column(name = "Skill")
    private String skill;

    public Housekeeper(Long sitterId, String firstName, String lastName, double basePrice, String skill) {
        super(sitterId, firstName, lastName, basePrice);
        this.skill = skill;
    }

    public Housekeeper(String skill) {
        this.skill = skill;
    }

    protected Housekeeper(){

    }
}
