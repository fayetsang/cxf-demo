import java.net.URL;

import org.codehaus.xfire.client.Client;
import org.junit.Test;

public class ClientTest {

    @Test
    public void test01() throws Exception {
        Client client = new Client(new URL("http://localhost:8080/xfire/test/UserService?wsdl"));

        Object[] objects = {"xiaoming"};
        Object[] sayHis = client.invoke("sayHi", objects);
        System.out.println(sayHis[0].toString());
    }

}
