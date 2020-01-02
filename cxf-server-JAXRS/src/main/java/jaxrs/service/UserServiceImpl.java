package jaxrs.service;

import java.util.ArrayList;
import java.util.List;

import jaxrs.domain.Car;
import jaxrs.domain.User;

public class UserServiceImpl implements UserService {

    public void addUser(User user) {
        System.out.println("server: addUser " + user);
    }

    public void updateUser(User user) {
        System.out.println("server: updateUser " + user);
    }

    @Override
    public void deleteUserByName(String name) {
        System.out.println("server: deleteUserByName " + name);
    }

    public List<User> findAll() {
        List<User> userList = new ArrayList();
        User user = null;
        user = new User();
        user.setName("xiaoming");
        userList.add(user);
        user = new User();
        user.setName("xiaohong");
        userList.add(user);
        System.out.println("server: getAll");
        return userList;

    }

    public User getUserByName(String userName) {
        User user = new User();
        if ("xiaoming".equals(userName)) {
            ArrayList<Car> list = new ArrayList();
            Car car1 = new Car();
            car1.setBand("Honda");
            car1.setPrice(20000d);
            list.add(car1);
            Car car2 = new Car();
            car2.setBand("BMW");
            car2.setPrice(400000d);
            list.add(car2);

            user.setName("xiaoming");
            user.setCars(list);
        }
        System.out.println("server: getUserByName");
        return user;
    }
}
