package kata_task_2_3_1.model;



import javax.validation.ConstraintViolation;
import javax.validation.Validator;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;


@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    @Pattern(regexp = "[A-zА-я]+", message = "Invalid name")
    private String name;

    @Column(name = "surname")
    @NotNull
    @Pattern(regexp = "[A-zА-я]+", message = "Invalid surname")
    private String surname;

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public boolean validate(Validator validator) {
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(this);
        return constraintViolations.size() == 0;
    }

}
