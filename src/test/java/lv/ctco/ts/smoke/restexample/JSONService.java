package lv.ctco.ts.smoke.restexample;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Path("/rest")
public class JSONService {

    public static List<Cat> cats = new ArrayList<>();

    @GET
    @Path("/cat")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cat> getCatInJSON() {
        cats=JsonUtils.getCats();
        System.out.println(cats);
        return cats;
    }

    @GET
    @Path("/cat/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cat getCatInJSON(@PathParam("id") int id) {
        cats=JsonUtils.getCats();
        System.out.println(cats.get(id));
        return cats.get(id);
    }

    @POST
    @Path("/cat")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCatInJSON(Cat cat) {
        //cat.setId(cats.size());
        String result = "Cat saved : " + cat;
        cats=JsonUtils.getCats();
        cats.add(cat);
        System.out.println("Add new cat to list:" + cat);
        JsonUtils.saveToFile(cats);
        return Response.status(201).entity(result).build();
    }

    @PUT
    @Path("/cat/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCatInJSON(Cat cat, @PathParam("id") int id) {
        cats=JsonUtils.getCats();
        try {
            Cat currentCat = cats.get(id);
            currentCat.update(cat);
            System.out.println(format("Cat with id=%s, was updated: ", id) + cat.toString());
            JsonUtils.saveToFile(cats);
            return Response.status(200).entity(format("Cat with id=%s, was updated: ", id) + cat).build();

        } catch (IndexOutOfBoundsException e) {
            return Response.status(200).entity(format("Cat with id=%s is not found", id)).build();
        }

    }

    @DELETE
    @Path("/cat/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCatInJSON(@PathParam("id") int id) {
        cats=JsonUtils.getCats();
        try {
            cats.remove(id);
            System.out.println(format("Cat with id=%s, was removed: ", id));
            JsonUtils.saveToFile(cats);
            return Response.status(200).entity(format("Cat with id=%s, was removed: ", id)).build();

        } catch (IndexOutOfBoundsException e) {
            return Response.status(200).entity(format("Cat with id=%s is not found", id)).build();
        }
    }

}