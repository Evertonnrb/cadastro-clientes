package br.com.cad.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eveton
 */
public class EntityManagerUtil {
    
    private static EntityManagerFactory factory = null;
    private static EntityManager manager = null;
    
    public static EntityManager getEntityManager(){
        if(factory == null){
            factory = Persistence.createEntityManagerFactory("ifsulPU");
        }
        if(manager == null){
            manager = factory.createEntityManager();
        }
        return manager;
    }
}
