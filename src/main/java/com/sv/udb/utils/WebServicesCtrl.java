/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.utils;

import com.sv.udb.modelo.Alumnos;
import com.sv.udb.modelo.Empleados;
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
    
    public List<Empleados> consEmplByAlum(String carn)
    {
        List<Empleados> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            String query = "SELECT e.*, s.nomb FROM empleados e INNER JOIN seccempl se ON e.codi = se.codi_empl " +
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
}
