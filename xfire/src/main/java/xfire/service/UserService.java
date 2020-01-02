package xfire.service;

import java.util.List;

import xfire.domain.Car;
import xfire.domain.User;

public interface UserService {

    public String sayHi(String name);

    public List<Car> getPriceByUser(User user);

}
