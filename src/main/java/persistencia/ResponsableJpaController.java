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
import logica.Responsable;

/**
 *
 * @author antonella
 */
public class ResponsableJpaController implements Serializable {
    
    private EntityManagerFactory emf = null;

    public ResponsableJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ResponsableJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultorioOdontologico_PU");
    }
    
    public void create(Responsable objeto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void edit(Responsable objeto) {
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
            Responsable objeto = em.getReference(Responsable.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public List<Responsable> findResponsableEntities() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Responsable e").getResultList();
        } finally { em.close(); }
    }
    
    public Responsable findResponsable(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Responsable.class, id);
        } finally { em.close(); }
    }

}
