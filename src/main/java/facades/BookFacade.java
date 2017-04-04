/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author madsr
 */
public class BookFacade
{

    EntityManagerFactory emf;

    public BookFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void addBook(Book b) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try {
            em.persist(b);
        } finally
        {
            em.getTransaction().commit();
            em.close();
        }
    }
    
    public List<Book> getBooks(String b) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try {
            
        return em.createQuery("SELECT u FROM book WHERE name = " + b).getResultList();
        } finally {
            em.getTransaction().commit();
            em.close();
        }
    }
    
    public void DeleteBook(String b)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin(); 
        
         try {
            em.getTransaction().begin();
            Book bk = em.find(Book.class, b);
            em.remove(bk);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void UpdateBook(Book b)
    {
        EntityManager em = emf.createEntityManager(); 
        try {

            em.getTransaction().begin();
            Book bk = em.find(Book.class, b.getId());
            bk = em.merge(b);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
}
