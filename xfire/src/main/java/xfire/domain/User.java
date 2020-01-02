package xfire.domain;

import java.util.List;

public class User {
    private String name;
    private List<Car> cars;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", cars=" + cars + "]";
    }
}
