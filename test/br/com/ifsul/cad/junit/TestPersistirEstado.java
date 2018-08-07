/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsul.cad.junit;

import br.com.cad.domain.Estado;
import br.com.cad.domain.Pais;
import br.com.cad.util.EntityManagerUtil;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author eveton
 */
public class TestPersistirEstado {
   
    EntityManager em;
    
    public TestPersistirEstado() {
    }
   
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void gerarTabelas(){
        em.getTransaction().begin();
    }
    
    @Test
    @Ignore
    public void testarEstadoPersistencia(){
        boolean exception = false;
        try {
            Estado e = new Estado();
            e.setNome("Minas Gerais");
            e.setUf("MG");
            e.setPais(em.find(Pais.class, 1));
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
        }
        Assert.assertEquals(false, exception);
    }
    
}
