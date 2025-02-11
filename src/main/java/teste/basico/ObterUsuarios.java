package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObterUsuarios {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("projeto-jpa");
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT u FROM Usuario u";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
        query.setMaxResults(2);

        List<Usuario> usuarios = query.getResultList();

        for(Usuario u : usuarios) {
            System.out.println("ID: " + u.getId()
            + "\nNome: " + u.getNome());
        }

        em.close();
        emf.close();
    }
}
