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
    
    public List<Book> getBooks() {
        EntityManager em = emf.createEntityManager();
        try {            
        return em.createQuery("SELECT b FROM Book b").getResultList();
        } finally {
            em.close();
        }
    }
    
    public Book getBookByID(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Book.class, id);
        } finally {
            em.close();
        }
    }
    
    public void DeleteBook(int id)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin(); 
        
         try {
            em.getTransaction().begin();
            Book bk = em.find(Book.class, id);
            em.remove(bk);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public Book UpdateBook(Book b)
    {
        EntityManager em = emf.createEntityManager(); 
        try {
            em.getTransaction().begin();
            Book bk = em.find(Book.class, b.getId());
            b = em.merge(bk);
            em.getTransaction().commit();
            return b;
        } finally {
            em.close();
        }
    }
    
}
