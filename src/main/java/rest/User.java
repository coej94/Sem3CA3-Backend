package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Book;
import facades.BookFacade;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("demouser")
@RolesAllowed("User")
public class User {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    BookFacade f = new BookFacade(Persistence.createEntityManagerFactory("pu_development"));
  
//  @GET
//  @Produces(MediaType.APPLICATION_JSON)
//  public String getSomething(){
//    return "{\"message\" : \"Hello User from Server (Accesible by only authenticated USERS)\"}"; 
//  }
//  @GET
//  @Path("footballclubs")
//  @Produces(MediaType.APPLICATION_JSON)
//  public String getClubs(){
//    return "[{\"name\":\"Liverpool\", \"url\":\"http://www.liverpoolfc.com\"},\n" +
//" {\"name\":\"Manchester United\",\"url\" : \"http://www.manutd.com/\"}]"; 
//  }
  
 
}