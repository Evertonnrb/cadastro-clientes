package br.com.cad.testes;

import br.com.cad.domain.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author eveton
 */
public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ifsulPU");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        salvar();
        //editar();
        //excluir();
        //buscarPorId();
    }

    public static void salvar() {
        Pais p = new Pais("", "wewPR");
        Validator v = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = v.validate(p);
        if(erros.size()>0){
            for(ConstraintViolation<Pais> erro : erros){
                System.out.println(erro.getMessage());
            }
        }else{
        em.getTransaction().begin();
        em.persist(p);    
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public static void editar(){
        Pais p = em.find(Pais.class, 2);
        //p.setNome("Brazil");
        p.setIso("PAY");
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public static void excluir(){
        em.getTransaction().begin();
        Pais p = em.find(Pais.class, 5);
        em.remove(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public static void buscarPorId(){
        em.getTransaction().begin();
        Pais p = em.find(Pais.class, 1);
        System.out.println(p.getNome()+" "+p.getIso());
        
    }
    
    
}
