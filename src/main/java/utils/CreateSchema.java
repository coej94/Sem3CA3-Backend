/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.persistence.Persistence;

/**
 *
 * @author Staal
 */
public class CreateSchema {
    public static void main(String[] args) {
        
        Persistence.createEntityManagerFactory("pu_development");
        Persistence.generateSchema("pu_development", null);
    }
}
