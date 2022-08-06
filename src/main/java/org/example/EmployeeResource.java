package org.example;

import com.sun.net.httpserver.Headers;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.util.List;
import java.util.Map;

@Path("employees")
public class EmployeeResource {

    EmployeeServiceImpl empServ = new EmployeeServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees()
    {
        return empServ.getAll();
    }



    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("id") int id)
    {
        // , @CookieParam(), @FormParam , @HeaderParam()
        Employee emp = empServ.getEmployee(id);
        if( emp == null) {
            Response response = Response.status(404).build();
            return response;
        }
        Response response = Response.ok()
                .entity(emp)
                .header("Access-Control-Allow-Origin", "*")
                .build();

        return response;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee addEmployee(Employee emp)
    {
        System.out.println("got to add " + emp);
        return empServ.addEmployee(emp);
    }

//    @PUT edit an employee
//    @PATCH edit only some part of object (int id, Employee emp updated only the portion that is not null)
//        (int id, String property[], Object values[])
//    @DELETE
//            (int id)
//    boolean true/false


}
