/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

/**
 *
 * @author REGISTRO
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sv.udb.modelo.Alumnos;
import com.sv.udb.modelo.Empleados;
import com.sv.udb.modelo.Seccalum;
import com.sv.udb.modelo.Usuarios;
import com.sv.udb.utils.MiHash;
import com.sv.udb.utils.WebServicesCtrl;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/MiServicio")
public class MiWebServices {
    @GET
    @Path("consLogi/{user}/{pass}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getMsg(@PathParam("user") String user, @PathParam("pass") String pass) {
        try
        {
            Usuarios obje = new WebServicesCtrl().cons(user, pass);
            ObjectMapper mapa = new ObjectMapper();
            JsonNode objeJson = mapa.createObjectNode();
//            ArrayNode nodoJson = mapa.createArrayNode();
            //JsonNode elemJson = mapa.createObjectNode();
            if(obje!= null)
            {
                ((ObjectNode) objeJson).put("resp", Boolean.TRUE);
                if(obje.getCodiAlum() != null)
                {
                    ((ObjectNode) objeJson).put("carn", obje.getCodiAlum().getCarn());
                    ((ObjectNode) objeJson).put("nomb", obje.getCodiAlum().getNomb() + " " + obje.getCodiAlum().getApel());
                    ((ObjectNode) objeJson).put("foto", obje.getCodiAlum().getFoto());
                    ((ObjectNode) objeJson).put("mail", obje.getCodiAlum().getMail());
                    ((ObjectNode) objeJson).put("grad", obje.getCodiAlum().getGrad());
                    ((ObjectNode) objeJson).put("espe", obje.getCodiAlum().getEspe());
                    ((ObjectNode) objeJson).put("grup", obje.getCodiAlum().getGrup());
                    ((ObjectNode) objeJson).put("seccAcad", obje.getCodiAlum().getSeccAcad());
                    ((ObjectNode) objeJson).put("seccTecn", obje.getCodiAlum().getSeccTecn());
                    ((ObjectNode) objeJson).put("dire", obje.getCodiAlum().getDire());
                    ((ObjectNode) objeJson).put("tipo", "alum");
                }
                else
                {
                    ((ObjectNode) objeJson).put("nomb", obje.getCodiEmpl().getNomb() + " " + obje.getCodiEmpl().getApel());
                    ((ObjectNode) objeJson).put("foto", obje.getCodiEmpl().getFoto());
                    ((ObjectNode) objeJson).put("mail", obje.getCodiEmpl().getMail());
                    String tipo;
                    switch(obje.getCodiEmpl().getTipoEmpl())
                    {
                        case 1:
                            tipo = "doceTecn";
                            break;
                        case 2:
                            tipo = "doceAcad";
                            break;
                        case 3:
                            tipo = "emplAdmi";
                            break;
                        case 4:
                            tipo = "emplRece";
                            break;
                        default:
                            tipo = "N/D";
                            break;
                    }
                    ((ObjectNode) objeJson).put("tipo", tipo);
                }
                ((ObjectNode) objeJson).put("esta", obje.getEstaUsua());
            }
            else
            {
                ((ObjectNode) objeJson).put("resp", Boolean.FALSE);
            }
            mapa.configure(SerializationFeature.INDENT_OUTPUT, true);
            StringWriter sali = new StringWriter();
            mapa.writeValue(sali, objeJson);
            return Response.status(200).entity(sali.toString()).build();
        }
        catch(Exception ex)
        {
            return Response.status(200).entity("Error: " + ex.getMessage()).build();
        }
    }
    
    @GET
    @Path("consAlum/{carn}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getMsg(@PathParam("carn") String carn) {
        try
        {
            Alumnos obje = new WebServicesCtrl().consAlum(carn);
            ObjectMapper mapa = new ObjectMapper();
            JsonNode objeJson = mapa.createObjectNode();
            if(obje!= null)
            {
                ((ObjectNode) objeJson).put("resp", Boolean.TRUE);
                ((ObjectNode) objeJson).put("carn", obje.getCarn());
                ((ObjectNode) objeJson).put("nomb", obje.getNomb() + " " + obje.getApel());
                ((ObjectNode) objeJson).put("foto", obje.getFoto());
                ((ObjectNode) objeJson).put("mail", obje.getMail());
                ((ObjectNode) objeJson).put("grad", obje.getGrad());
                ((ObjectNode) objeJson).put("espe", obje.getEspe());
                ((ObjectNode) objeJson).put("grup", obje.getGrup());
                ((ObjectNode) objeJson).put("seccAcad", obje.getSeccAcad());
                ((ObjectNode) objeJson).put("seccTecn", obje.getSeccTecn());
                ((ObjectNode) objeJson).put("dire", obje.getDire());
                ((ObjectNode) objeJson).put("reli", obje.getReli());
                ((ObjectNode) objeJson).put("tele", obje.getTele());
                ((ObjectNode) objeJson).put("lugaNaci", obje.getLugaNaci());
                ((ObjectNode) objeJson).put("fechNaci", obje.getFechNaci().getTime());
                ((ObjectNode) objeJson).put("fina", obje.getFina());
                ((ObjectNode) objeJson).put("instOrig", obje.getInstOrig());
                ((ObjectNode) objeJson).put("esta", obje.getEsta());
                ArrayNode nodoJson = mapa.createArrayNode();
                for(Empleados temp : new WebServicesCtrl().consEmplByAlum(obje.getCarn()))
                {
                    JsonNode elemJson = mapa.createObjectNode();
                    ((ObjectNode) elemJson).put("codi", temp.getCodi());
                    ((ObjectNode) elemJson).put("nomb", temp.getNomb() + " " + temp.getApel());
                    ((ObjectNode) elemJson).put("foto", temp.getFoto());
                    ((ObjectNode) elemJson).put("secc", "N/D");
                    nodoJson.add(elemJson);
                }
                ((ObjectNode) objeJson).put("doce", nodoJson);
            }
            else
            {
                ((ObjectNode) objeJson).put("resp", Boolean.FALSE);
            }
            mapa.configure(SerializationFeature.INDENT_OUTPUT, true);
            StringWriter sali = new StringWriter();
            mapa.writeValue(sali, objeJson);
            return Response.status(200).entity(sali.toString()).build();
        }
        catch(Exception ex)
        {
            return Response.status(200).entity("Error: " + ex.getMessage()).build();
        }
    }
    
    @GET
    @Path("consUsua/{nomb}/{apel}/{tipo}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getMsg(@PathParam("nomb") String nomb, @PathParam("apel") String apel, @PathParam("tipo") String tipo) {
        try
        {
            List<Object[]> obje = new WebServicesCtrl().consListUsua(nomb.trim(), apel.trim(), tipo.trim());
            ObjectMapper mapa = new ObjectMapper();
            JsonNode objeJson = mapa.createObjectNode();
            if(obje != null)
            {
                ((ObjectNode) objeJson).put("resp", Boolean.TRUE);
                ArrayNode nodoJson = mapa.createArrayNode();
                for(Object[] temp : obje)
                {
                    JsonNode elemJson = mapa.createObjectNode();
                    ((ObjectNode) elemJson).put("nomb", (String)temp[0]);
                    ((ObjectNode) elemJson).put("apel", (String)temp[1]);
                    ((ObjectNode) elemJson).put("foto", (byte[])temp[2]);
                    ((ObjectNode) elemJson).put("usua", (String)temp[3]);
                    ((ObjectNode) elemJson).put("tipo", (String)temp[4]);
                    nodoJson.add(elemJson);
                }
                ((ObjectNode) objeJson).put("resu", nodoJson);
            }
            else
            {
                ((ObjectNode) objeJson).put("resp", Boolean.FALSE);
            }
            mapa.configure(SerializationFeature.INDENT_OUTPUT, true);
            StringWriter sali = new StringWriter();
            mapa.writeValue(sali, objeJson);
            return Response.status(200).entity(sali.toString()).build();
        }
        catch(Exception ex)
        {
            return Response.status(200).entity("Error: " + ex.getMessage()).build();
        }
    }
    
    
    @GET
    @Path("consUsua/{usua}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getMsgByUsua(@PathParam("usua") String usua) {
        try
        {
            Object[] obje = new WebServicesCtrl().consUsua(usua.trim());
            ObjectMapper mapa = new ObjectMapper();
            JsonNode objeJson = mapa.createObjectNode();
            if(obje != null)
            {
                ((ObjectNode) objeJson).put("resp", Boolean.TRUE);
                ((ObjectNode) objeJson).put("nomb", (String)obje[0]);
                ((ObjectNode) objeJson).put("apel", (String)obje[1]);
                ((ObjectNode) objeJson).put("foto", (byte[])obje[2]);
                ((ObjectNode) objeJson).put("usua", (String)obje[3]);
                ((ObjectNode) objeJson).put("tipo", (String)obje[4]);
            }
            else
            {
                ((ObjectNode) objeJson).put("resp", Boolean.FALSE);
            }
            mapa.configure(SerializationFeature.INDENT_OUTPUT, true);
            StringWriter sali = new StringWriter();
            mapa.writeValue(sali, objeJson);
            return Response.status(200).entity(sali.toString()).build();
        }
        catch(Exception ex)
        {
            return Response.status(200).entity("Error: " + ex.getMessage()).build();
        }
    }
}
