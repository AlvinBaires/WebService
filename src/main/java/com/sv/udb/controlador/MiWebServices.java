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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sv.udb.utils.AlumnosCtrl;
import com.sv.udb.utils.AlumnosResponse;
import java.io.StringWriter;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/MiServicio")
public class MiWebServices {
    @GET
    @Path("/{user}/{pass}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getMsg(@PathParam("user") String user, @PathParam("pass") String pass) {
        try
        {
            AlumnosResponse obje = new AlumnosCtrl().cons(user, pass);
            ObjectMapper mapa = new ObjectMapper();
            mapa.configure(SerializationFeature.INDENT_OUTPUT, true);
            StringWriter sali = new StringWriter();
            mapa.writeValue(sali, obje);
            return Response.status(200).entity(sali.toString()).build();
        }
        catch(Exception ex)
        {
            return Response.status(200).entity("Error").build();
        }
    }
    
    @GET
    @Path("/{user}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getMsgByUsua(@PathParam("user") String user) {
        try
        {
            AlumnosResponse obje = new AlumnosCtrl().consByUsua(user);
            ObjectMapper mapa = new ObjectMapper();
            mapa.configure(SerializationFeature.INDENT_OUTPUT, true);
            StringWriter sali = new StringWriter();
            mapa.writeValue(sali, obje);
            return Response.status(200).entity(sali.toString()).build();
        }
        catch(Exception ex)
        {
            return Response.status(200).entity("Error").build();
        }
    }
}
