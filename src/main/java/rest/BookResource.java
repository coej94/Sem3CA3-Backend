/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Book;
import facades.BookFacade;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Staal
 */
@Path("Book")
@RolesAllowed("User")
public class BookResource {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    BookFacade f = new BookFacade(Persistence.createEntityManagerFactory("pu_development"));

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookResource
     */
    public BookResource() {
    }
    
    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllBooks() {
        List<Book> lb = f.getBooks();
        if (lb == null) {
            throw new NotFoundException("No books available");
        }
        String json = gson.toJson(lb);
        return json;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook(String json) {
        Book b = gson.fromJson(json, Book.class);
        try {
            f.addBook(b);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity("Error in addPerson").build();
        }
        return Response.status(200).entity(gson.toJson(b)).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteBook(@PathParam("id") int id) {
        Book b = f.getBookByID(id);
        if (b != null) {
            f.DeleteBook(b.getId());
        } else {
            throw new NotFoundException();
        }
    }

    @PUT
    @Path("editBook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String editPerson(String json) {
        Book b = gson.fromJson(json, Book.class);
        f.UpdateBook(b);
        return gson.toJson(b);
    }
}
