package br.com.cad.testes;

import br.com.cad.domain.Estado;
import br.com.cad.domain.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eveton
 */
public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ifsulPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Estado estado = new Estado("Mato Grosso","MT",em.find(Pais.class, 1));
        em.merge(estado);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
