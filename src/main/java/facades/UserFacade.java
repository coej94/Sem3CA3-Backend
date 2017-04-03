package facades;

import security.IUserFacade;
import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import security.IUser;
import security.PasswordStorage;

public class UserFacade implements IUserFacade {

  EntityManagerFactory emf;

  public UserFacade(EntityManagerFactory emf) {
    this.emf = emf;   
  }

  private EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  @Override
  public IUser getUserByUserId(String id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(User.class, id);
    } finally {
      em.close();
    }
  }

  /*
  Return the Roles if users could be authenticated, otherwise null
   */
  @Override
  public List<String> authenticateUser(String userName, String password) {
    IUser user = getUserByUserId(userName);
    return user != null && password.equals(user.getPassword()) ? user.getRolesAsStrings() : null;  
  }

  public void createUser(String userName, String password) throws PasswordStorage.CannotPerformOperationException{
     EntityManager em = emf.createEntityManager();
     User user = new User(userName, password);
     try {
         em.getTransaction().begin();
         em.persist(user);
         em.getTransaction().commit();
     } finally {
         em.close();
     }
  }
}