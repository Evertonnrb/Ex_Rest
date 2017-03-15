
package service;

import Dao.UsuarioDao;
import com.google.gson.Gson;
import entidade.Usuario;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author everton
 */
@Path("Usuario")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of service.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getXml() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "Testando....";
    }
    @GET
    @Produces("application/json")
    @Path("Usuario/logar/{email}")
    public String logar(@PathParam("email")String email){

        Usuario usu = new Usuario();
        usu.setEmail(email);

        UsuarioDao dao = new UsuarioDao();
        usu = dao.buscar(email);

        Gson g = new Gson();
        return g.toJson(usu);
    }
    @GET
    @Produces("application/json")
    @Path("Usuario/authenticacao/{email}/{senha}")
    public String autenticacao(@PathParam("email")String email,
                @PathParam("senha")String senha){
        
        Usuario usu = new Usuario();
        usu.setEmail("tutu@gmail");
        usu.setSenha("1232112");

        UsuarioDao dao = new UsuarioDao();
        usu = dao.login(email, senha);
        
        Gson g = new Gson();
        return g.toJson(usu);
    }
    
    @GET
    @Produces("application/json")
    @Path("Usuario/get")
    public String getNomeUsuario(){
        
        UsuarioDao dao = new UsuarioDao();
        List<Usuario> usu = dao.listar();
    
        
        //Usuario usu = new Usuario();
//        usu.setNome("Notreve");
//        usu.setEmail("notreve@not.com");
//        usu.setSenha("1221211221");
//        usu.setPerfil("ADM");
        Gson g = new Gson();
        return g.toJson(usu);
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
