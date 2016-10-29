/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.utils;

//import com.sv.udb.modelo.Usuarios;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;

/**
 *
 * @author REGISTRO
 */
public class AlumnosCtrl {
//    public Usuarios cons(String usua, String pass)
//    {
//        AlumnosResponse resp = new AlumnosResponse();
//        resp.setResp(false);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
//        EntityManager em = emf.createEntityManager();
//        try
//        {
//            Query q = em.createQuery("SELECT u FROM Usuarios u WHERE u.acceUsua = :acceUsua AND u.contUsua = :contUsua AND u.estaUsua = :estaUsua", Usuarios.class);
//            q.setParameter("acceUsua", usua);
//            q.setParameter("contUsua", pass);
//            q.setParameter("estaUsua", 1);
//            List results = q.getResultList();
//            if (!results.isEmpty())
//            {
//                Usuarios obje = (Usuarios)results.get(0);
//                resp.setResp(true);
//                resp.setNomb(String.format("%s %s", obje.getCodiAlum().getNombAlum(), obje.getCodiAlum().getApelAlum()));
//                resp.setMail(obje.getCodiAlum().getMailAlum());
//                resp.setFechNaci(obje.getCodiAlum().getFechNaciAlum());
//                resp.setUsua(obje.getAcceUsua());
//            }
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        finally
//        {
//            em.close();
//            emf.close();            
//        }
//        return resp;
//    }
    
//    public AlumnosResponse consByUsua(String usua)
//    {
//        AlumnosResponse resp = new AlumnosResponse();
//        resp.setResp(false);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
//        EntityManager em = emf.createEntityManager();
//        try
//        {
//            Query q = em.createQuery("SELECT u FROM Usuarios u WHERE u.acceUsua = :acceUsua AND u.estaUsua = :estaUsua", Usuarios.class);
//            q.setParameter("acceUsua", usua);
//            q.setParameter("estaUsua", 1);
//            List results = q.getResultList();
//            if (!results.isEmpty())
//            {
//                Usuarios obje = (Usuarios)results.get(0);
//                resp.setResp(true);
//                resp.setNomb(String.format("%s %s", obje.getCodiAlum().getNombAlum(), obje.getCodiAlum().getApelAlum()));
//                resp.setMail(obje.getCodiAlum().getMailAlum());
//                resp.setFechNaci(obje.getCodiAlum().getFechNaciAlum());
//                resp.setUsua(obje.getAcceUsua());
//            }
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        finally
//        {
//            em.close();
//            emf.close();            
//        }
//        return resp;
//    }
}
