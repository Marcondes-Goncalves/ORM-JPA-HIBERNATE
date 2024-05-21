package com.marcondes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    
    public static EntityManagerFactory factory = null;

    static {
        init();
    }

    private static void init(){

        try {

            //Ler as configurações no arquivo persistence.xml e conectar ao banco de dados
            if (factory == null) {
                factory = Persistence.createEntityManagerFactory("pos-java-maven-hibernate");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EntityManager gEntityManager(){
        return factory.createEntityManager(); /* Prove a parte de persistência  */
    }
}
