package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("projeto-jpa");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = new Usuario("Joe", "joe@gmail.com");

        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
