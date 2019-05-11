package com.paf.n3ag6.services;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.paf.n3ag6.models.Enums.UserType;
import com.paf.n3ag6.models.User;

@Path("/user")
public class UserService {

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public User GetUser(@PathParam("name") String name) {

		User usr = new User();
		usr.setUsername(name);
		usr.setUserType(UserType.ADMIN);
		usr.setContactNo("0777812418");
		usr.setEmail("email@email.com");
		usr.setPassword("1111");
		usr.setProfilePicture("aaa");
		usr.setIsActive(true);

		return usr;
	}

	@PUT
	@Path("/{name}")
	public Response EditUserStatus(@PathParam("name") String name) {

		String output = "Jersey say : Bullshit ";

		return Response.status(200).entity(output).build();

	}

	@POST
	@Path("/{name}/address")
	public Response AddAddressStatus(@PathParam("name") String name) {

		String output = "Jersey say : Bullshit ";

		return Response.status(200).entity(output).build();

	}

	@DELETE
	@Path("/{name}/address/{id}")
	public Response DeleteAddressStatus(@PathParam("name") String name, @PathParam("id") int id) {

		String output = "Jersey say : Bullshit ";

		return Response.status(200).entity(output).build();

	}

	@POST
	@Path("/login")
	public Response Authenticate() {

		String output = "Jersey say : Bullshit ";

		return Response.status(200).entity(output).build();

	}

}