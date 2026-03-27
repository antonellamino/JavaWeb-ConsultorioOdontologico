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
import logica.Turno;

/**
 *
 * @author antonella
 */
public class TurnoJpaController implements Serializable {
    
    private EntityManagerFactory emf = null;

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public TurnoJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultorioOdontologico_PU");
    }

    public void create(Turno objeto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void edit(Turno objeto) {
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
            Turno objeto = em.getReference(Turno.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public List<Turno> findTurnoEntities() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Turno e").getResultList();
        } finally { em.close(); }
    }
    
    public Turno findTurno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally { em.close(); }
    }
}
