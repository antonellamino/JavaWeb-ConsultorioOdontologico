/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Secretario;

/**
 *
 * @author antonella
 */
public class SecretarioJpaController implements Serializable {
    
    private EntityManagerFactory emf = null;

    public SecretarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    public SecretarioJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultorioOdontologico_PU");
    }

    public void create(Secretario objeto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void edit(Secretario objeto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void destroy(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Secretario objeto = em.getReference(Secretario.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public List<Secretario> findSecretarioEntities() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Secretario e").getResultList();
        } finally { em.close(); }
    }
    
    public Secretario findSecretario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Secretario.class, id);
        } finally { em.close(); }
    }
}
