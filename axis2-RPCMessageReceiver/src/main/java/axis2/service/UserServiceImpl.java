package axis2.service;

public class UserServiceImpl implements UserService {
    public String sayHi(String name) {
        String str = "hello, " + name;
        System.out.println("server print: " + str);
        return str;
    }
}
