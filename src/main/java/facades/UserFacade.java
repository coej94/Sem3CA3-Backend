package facades;

import security.IUserFacade;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        System.out.println(user.getPassword());
        if (user != null) {
            try {
                if (PasswordStorage.verifyPassword(password, user.getPassword())) {
                    System.out.println(user.getRolesAsStrings());
                    return user.getRolesAsStrings();
                    
                }
                
            } catch (PasswordStorage.CannotPerformOperationException ex) {
                System.out.println("cannot perfom operation exception authenticateUser 1");
            } catch (PasswordStorage.InvalidHashException ex) {
                System.out.println("cannot perfom operation exception authenticateUser 2");
            }
        } else {
            return null;
        }
        return null;
    }

    public void createUser(String userName, String password) throws PasswordStorage.CannotPerformOperationException {
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

    public static void main(String[] args) {
        UserFacade uf = new UserFacade(Persistence.createEntityManagerFactory("pu_development", null));
        List<String> hej = uf.authenticateUser("user", "test");
        System.out.println(hej);
    }
}
