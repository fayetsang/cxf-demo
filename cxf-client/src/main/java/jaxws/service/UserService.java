package jaxws.service;

import jaxws.domain.Car;
import jaxws.domain.User;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserService {

    public String sayHi(String name);

    public List<Car> getPriceByUser(User user);

}
