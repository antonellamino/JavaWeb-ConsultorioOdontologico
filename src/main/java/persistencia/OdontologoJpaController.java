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
import logica.Odontologo;
/**
 *
 * @author antonella
 */
public class OdontologoJpaController implements Serializable {
    
    private EntityManagerFactory emf = null;

    public OdontologoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public OdontologoJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultorioOdontologico_PU");
    }

    public void create(Odontologo objeto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void edit(Odontologo objeto) {
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
            Odontologo objeto = em.getReference(Odontologo.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public List<Odontologo> findOdontologoEntities() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Odontologo e").getResultList();
        } finally { em.close(); }
    }
    
    public Odontologo findOdontologo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Odontologo.class, id);
        } finally { em.close(); }
    }
}
