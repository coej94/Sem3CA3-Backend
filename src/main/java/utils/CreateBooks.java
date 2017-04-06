/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Book;
import facades.BookFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author christian
 */
public class CreateBooks {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
        try {
            BookFacade bf = new BookFacade(emf);
            
            Book b = new Book("How to Learn JavaScript - Vol 1", "Study hard", "");
            Book b1 = new Book("How to Learn React", "Complete all your CA's", "");
            Book b2 = new Book("How to become a specialist in Computer Science - Vol 4", "Don't drink beers, until Friday (after four)", "5 Points = 5 beers ;-)");
            Book b3 = new Book("How to Learn ES6", "Complete all exercises :-)", "");            
            bf.addBook(b);
            bf.addBook(b1);
            bf.addBook(b2);
            bf.addBook(b3);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("HA FAIL!");
        }
        
    }
}
