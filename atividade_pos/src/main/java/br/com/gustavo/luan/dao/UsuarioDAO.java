package br.com.gustavo.luan.dao;

import br.com.gustavo.luan.domain.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioDAO {
    
private EntityManagerFactory entityManagerFactory;

    
    public UsuarioDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("userPU");
    }
    
    public void save(Usuario user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    
    public void close() {
        entityManagerFactory.close();
    }
}