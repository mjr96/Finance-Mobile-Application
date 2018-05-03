/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmoj_ws;

import mmoj_classeBO.Mmoj_ControleBO;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import mmoj_objetos.Mmoj_Controle;

/**
 * REST Web Service
 *
 * @author Maria
 */
@Path("ControleFinancas")
public class Mmoj_ControleFinancasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ControleFinancasResource
     */
    public Mmoj_ControleFinancasResource() {
    }

    /**
     * Retrieves representation of an instance of ws.Mmoj_ControleFinancasResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mmoj_Controle> getJson() {
       return new Mmoj_ControleBO().mmoj_getControle();
    }

    /**
     * PUT method for updating or creating an instance of Mmoj_ControleFinancasResource
     * @param content representation for the resource
     */
     @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) 
    {
        Gson g = new Gson();
        
        Mmoj_Controle mmoj_controle = g.fromJson(content, Mmoj_Controle.class);
        
        new Mmoj_ControleBO().mmoj_salvarControle(mmoj_controle);
    }
}
