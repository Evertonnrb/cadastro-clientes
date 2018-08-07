package br.com.cad.testes;

import br.com.cad.domain.PessoaFisica;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eveton
 */
public class Main3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ifsulPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Pessoa p = new Pessoa("Bob Sponja","bob@gmail.com","77889988");
        PessoaFisica pf = new PessoaFisica();
        pf.setCpf("49408510011");
        pf.setRg("00099900");
        pf.setNome("bob");
        pf.setDataNascimento(Calendar.getInstance());
        pf.setEmail("bob@gmail.com");
        pf.setNomeUsuario("bob");
        pf.setSenha("123456");
        pf.setTelefone("9990999");
        em.merge(pf);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
