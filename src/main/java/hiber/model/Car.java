package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User empUser;


    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {
    }

    public User getUser(){
        return empUser;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getEmpUser() {
        return empUser;
    }

    public User setEmpUser(User empUser) {
        this.empUser = empUser;
        return empUser;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
