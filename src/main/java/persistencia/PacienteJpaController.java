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
import logica.Paciente;

/**
 *
 * @author antonella
 */
public class PacienteJpaController implements Serializable {
    
    private EntityManagerFactory emf = null;

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public PacienteJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultorioOdontologico_PU");
    }

    public void create(Paciente objeto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void edit(Paciente objeto) {
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
            Paciente objeto = em.getReference(Paciente.class, id);
            em.remove(objeto);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public List<Paciente> findPacienteEntities() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Paciente e").getResultList();
        } finally { em.close(); }
    }
    
    public Paciente findPaciente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally { em.close(); }
    }
}
