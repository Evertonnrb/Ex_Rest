
package DaoTest;

import Dao.UsuarioDao;
import entidade.Usuario;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author everton
 */
public class TestUsuarioDao {
    @Test
    @Ignore
    public void salvar(){
        Usuario usu =new Usuario();
        usu.setNome("Arthur");
        usu.setEmail("tutu@gmail");
        usu.setSenha("123212");
        usu.setPerfil("ADM");
        UsuarioDao dao = new UsuarioDao();
        dao.salvar(usu);
    }
    @Test
    @Ignore
    public void listar(){
        UsuarioDao dao = new UsuarioDao();
        List<Usuario> usu = dao.listar();
        for(Usuario u : usu){
            System.out.println(" "+u.getNome());
        }
        
    }
    @Test
    @Ignore
    public void buscarEmail(){
        UsuarioDao dao = new UsuarioDao();
        Usuario usu = dao.buscar("tutu@gmail");
        if(usu!=null){
            System.out.println(usu.getNome());
        }
    }
    @Test
    public void login(){
        UsuarioDao dao = new UsuarioDao();
        Usuario usu = dao.login("tutu@gmail", "1232212");
        if(usu!=null){
            System.out.println(usu.getEmail()+" "+usu.getSenha());
        }else{
            System.out.println("Usuario inválido");
        }
    }
}
