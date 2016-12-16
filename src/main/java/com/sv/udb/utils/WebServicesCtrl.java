/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.utils;

import com.sv.udb.modelo.Alumnos;
import com.sv.udb.modelo.Empleados;
import com.sv.udb.modelo.Famialum;
import com.sv.udb.modelo.Usuarios;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author REGISTRO
 */
public class WebServicesCtrl 
{
    public Usuarios cons(String usua, String pass)
    {
        Usuarios resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            Query q = em.createQuery("SELECT u FROM Usuarios u WHERE u.acceUsua = :acceUsua AND u.contUsua = :contUsua AND u.estaUsua = :estaUsua", Usuarios.class);
            q.setParameter("acceUsua", usua);
            q.setParameter("contUsua", pass);
            q.setParameter("estaUsua", 1);
            List results = q.getResultList();
            if (!results.isEmpty())
            {
                resp= (Usuarios)results.get(0);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public Alumnos consAlum(String carn)
    {
        Alumnos resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            Query q = em.createQuery("SELECT a FROM Alumnos a WHERE a.carn = :carn", Alumnos.class);
            q.setParameter("carn", carn);
            List results = q.getResultList();
            if (!results.isEmpty())
            {
                resp= (Alumnos)results.get(0);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public List<Alumnos> consAlum(String nomb, String apel, String grad, String espe)
    {
        List<Alumnos> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            Query q = em.createQuery("SELECT a FROM Alumnos a WHERE a.nomb LIKE :nomb OR a.apel LIKE :apel OR a.grad LIKE :grad OR a.espe LIKE :espe", Alumnos.class);
            q.setParameter("nomb", "%" + nomb + "%");
            q.setParameter("apel", "%" + apel + "%");
            q.setParameter("grad", "%" + grad + "%");
            q.setParameter("espe", "%" + espe + "%");
            resp = q.setMaxResults(10).getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public List<Alumnos> consAlumByDoce(int codi)
    {
        List<Alumnos> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            String query = "SELECT DISTINCT a.* FROM alumnos a INNER JOIN seccalum s ON a.codi = s.codi_alum " +
                            "WHERE s.codi_secc IN (SELECT codi_secc FROM seccempl WHERE codi_empl = ?1) AND a.esta = ?2";
            Query q = em.createNativeQuery(query, Alumnos.class);
            q.setParameter(1, codi);
            q.setParameter(2, 1);
            resp = q.getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public List<Empleados> consEmplByAlum(String carn)
    {
        List<Empleados> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            String query = "SELECT DISTINCT e.* FROM empleados e INNER JOIN seccempl se ON e.codi = se.codi_empl " +
                            "INNER JOIN secciones s ON se.codi_secc = s.codi " +
                            "WHERE se.codi_secc IN (SELECT codi_secc FROM seccalum sa INNER JOIN " +
                            "alumnos a ON sa.codi_alum = a.codi WHERE a.carn = ?1)";
            Query q = em.createNativeQuery(query, Empleados.class);
            q.setParameter(1, carn);
            resp = q.getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public List<Famialum> consFamByAlum(String carn)
    {
        List<Famialum> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            String query = "SELECT f.* FROM famialum f, alumnos a  WHERE f.esta=1 AND a.codi = f.codi_alum AND a.carn = ?1";
            Query q = em.createNativeQuery(query, Famialum.class);
            q.setParameter(1, carn);
            resp = q.getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public List<Object[]> consListUsua(String nomb, String apel, String tipo)
    {
        List<Object[]> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            String query = "SELECT * FROM ((SELECT a.nomb, a.apel, a.foto, u.acce_usua, \"alum\" tipo " +
                            "FROM usuarios u\n" +
                            "INNER JOIN alumnos a ON u.codi_alum = a.codi) " +
                            "UNION " +
                            "(SELECT e.nomb, e.apel, e.foto, u.acce_usua, (CASE e.tipo_empl WHEN 1 THEN 'doceTecn' WHEN 2 " +
                            "THEN 'doceAcad' WHEN 3 THEN 'emplAdmi' WHEN 4 THEN 'emplRece' ELSE 'N/D' END) tipo " +
                            "FROM usuarios u " +
                            "INNER JOIN empleados e ON u.codi_empl = e.codi)) t " +
                            "WHERE UPPER(t.nomb) LIKE UPPER(?1) OR UPPER(t.apel) LIKE UPPER(?2) " +
                            "OR UPPER(t.tipo) LIKE UPPER(?3) " +
                            "LIMIT 10";
            Query q = em.createNativeQuery(query);
            q.setParameter(1, "%" + nomb + "%");
            q.setParameter(2, "%" + apel + "%");
            q.setParameter(3, "%" + tipo + "%");
            resp = q.getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    public Object[] consUsua(String usua)
    {
        Object[] resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            String query = "SELECT * FROM ((SELECT a.nomb, a.apel, a.foto, u.acce_usua, \"alum\" tipo " +
                            "FROM usuarios u\n" +
                            "INNER JOIN alumnos a ON u.codi_alum = a.codi) " +
                            "UNION " +
                            "(SELECT e.nomb, e.apel, e.foto, u.acce_usua, (CASE e.tipo_empl WHEN 1 THEN 'doceTecn' WHEN 2 " +
                            "THEN 'doceAcad' WHEN 3 THEN 'emplAdmi' WHEN 4 THEN 'emplRece' ELSE 'N/D' END) tipo " +
                            "FROM usuarios u " +
                            "INNER JOIN empleados e ON u.codi_empl = e.codi)) t " +
                            "WHERE UPPER(t.acce_usua) = UPPER(?1) " +
                            "LIMIT 1";
            Query q = em.createNativeQuery(query);
            q.setParameter(1, usua);
            List results = q.getResultList();
            if (!results.isEmpty())
            {
                resp = (Object[])results.get(0);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    //Empleados
    public Empleados consEmpl(String usua)
    {
        Empleados resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            String query = "SELECT e.* FROM empleados e INNER JOIN usuarios u ON e.codi = u.codi_empl WHERE u.acce_usua = ?1";
            Query q = em.createNativeQuery(query, Empleados.class);
            q.setParameter(1, usua);
            List results = q.getResultList();
            if (!results.isEmpty())
            {
                resp= (Empleados)results.get(0);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public Empleados consEmpl(int codi)
    {
        Empleados resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            String query = "SELECT e.* FROM empleados e WHERE e.codi = ?1";
            Query q = em.createNativeQuery(query, Empleados.class);
            q.setParameter(1, codi);
            List results = q.getResultList();
            if (!results.isEmpty())
            {
                resp= (Empleados)results.get(0);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public List<Empleados> consListEmpl(String nomb, String apel)
    {
        List<Empleados> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            String query = "SELECT e FROM Empleados e WHERE e.nomb LIKE :nomb OR e.apel LIKE :apel";
            Query q = em.createQuery(query, Empleados.class);
            q.setParameter("nomb", "%" + nomb + "%");
            q.setParameter("apel", "%" + apel + "%");
            resp = q.setMaxResults(10).getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
}
