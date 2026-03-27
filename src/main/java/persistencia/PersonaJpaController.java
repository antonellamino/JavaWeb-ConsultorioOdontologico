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
import logica.Persona;

/**
 *
 * @author antonella
 */
public class PersonaJpaController implements Serializable {
    
    private EntityManagerFactory emf = null;

    public PersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public PersonaJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultorioOdontologico_PU");
    }

    public void create(Persona objeto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void edit(Persona objeto) {
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
            Persona objeto = em.getReference(Persona.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public List<Persona> findPersonaEntities() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Persona e").getResultList();
        } finally { em.close(); }
    }
    
    public Persona findPersona(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally { em.close(); }
    }
}
