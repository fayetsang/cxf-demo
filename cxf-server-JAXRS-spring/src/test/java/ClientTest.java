import java.util.Collection;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import jaxrs.domain.User;

public class ClientTest {
    String basePath = "http://localhost:8080/cxf-server-JAXRS-spring/rs/user";

    @Test
    public void testAdd() {
        User user = new User();
        user.setName("add");
        Response post = WebClient.create(basePath).type(MediaType.APPLICATION_XML).post(user);
        System.out.println(post.getStatus());
        System.out.println("client add user");
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setName("update");
        Response put = WebClient.create(basePath).type(MediaType.APPLICATION_JSON).put(user);
        System.out.println(put.getStatus());
        System.out.println("client update user");
    }

    @Test
    public void testDeleteUser() {
        Response delete = WebClient.create(basePath).type(MediaType.APPLICATION_XML).delete();
        System.out.println(delete.getStatus());
        System.out.println("client delete user");
    }

    @Test
    public void testGetUserByName(){
        User user = WebClient.create(basePath + "/xiaoming").accept(MediaType.APPLICATION_JSON).get(User.class);
        System.out.println(user.toString());
        System.out.println("client get user by Name");
    }

    @Test
    public void testGetAll() {
        Collection<? extends User> users = WebClient.create(basePath).type(MediaType.APPLICATION_JSON).getCollection(User.class);
        for (User user : users) {
            System.out.println(user.toString());
        }
        System.out.println("client get all user");
    }
}
