package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Academic")
@Access(AccessType.FIELD)
public class Academic extends Sitter {
    @Column(name = "Subject")
    private String subject;

    @Column(name = "Max_age")
    private int max_age;

    @Column(name = "Bonus")
    private double bonus;

    public Academic(String firstName, String lastName, double basePrice, String subject, int max_age, double bonus) {
        super(firstName, lastName, basePrice);
        this.subject = subject;
        this.max_age = max_age;
        this.bonus = bonus;
    }

    public Academic(String subject, int max_age, double bonus) {
        this.subject = subject;
        this.max_age = max_age;
        this.bonus = bonus;
    }

    protected Academic() {

    }
}
