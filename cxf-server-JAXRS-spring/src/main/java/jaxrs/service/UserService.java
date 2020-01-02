package jaxrs.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import jaxrs.domain.User;

@WebService
public interface UserService {

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    void addUser(User user);

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateUser(User user);

    @DELETE
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void deleteUserByName(String deleteUserByName);

    @GET
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<User> findAll();

    @GET
    @Path("/{userName}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    User getUserByName(@PathParam("userName") String userName);
}
