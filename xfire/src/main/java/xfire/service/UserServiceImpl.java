package xfire.service;

import java.util.ArrayList;
import java.util.List;

import xfire.domain.Car;
import xfire.domain.User;

public class UserServiceImpl implements UserService {
    public String sayHi(String name) {
        String str = "hello, " + name;
        System.out.println("server print: " + str);
        return str;
    }

    public List<Car> getPriceByUser(User user) {
        List<Car> list = null;
        //模拟数据库中获取数据
        if("xiaoming".equals(user.getName())){
            list = new ArrayList();
            Car car1 = new Car();
            car1.setBand("Honda");
            car1.setPrice(20000d);
            list.add(car1);
            Car car2 = new Car();
            car2.setBand("BMW");
            car2.setPrice(400000d);
            list.add(car2);

        }
        System.out.println("server :"+list);
        return list;

    }
}
