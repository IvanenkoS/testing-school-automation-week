package lv.ctco.ts.smoke.restexample;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

@Path("/rest")
public class JSONService {

    public static List<Cat> cats = new ArrayList<>();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cat> getCatInJSON() {
        System.out.println(cats);
        return cats;
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCatInJSON(Cat cat) {
        String result = "Cat saved : " + cat;
        cats.add(cat);
        System.out.println("Add new cat to list:"+cat);
        return Response.status(201).entity(result).build();
    }

    @PUT
    @Path("/put/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCatInJSON(Cat cat, @PathParam("id") int id) {
        System.out.println(id);
      // for (Cat currentCat:cats){
      //     if (currentCat.getId()==id){
      //         currentCat.setName(cat.getName());
      //         currentCat.setAge(cat.getAge());
      //         currentCat.setColor(cat.getColor());
      //         System.out.println(format("Cat with id=%s, was updated: ", id)+cat.toString());
      //     }
      // }
      // String result = format("Cat with id=%s, was updated: ", id)+cat;
        return Response.status(200).entity("").build();
    }

}