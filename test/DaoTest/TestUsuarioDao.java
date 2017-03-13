
package DaoTest;

import Dao.UsuarioDao;
import entidade.Usuario;
import org.junit.Test;

/**
 *
 * @author everton
 */
public class TestUsuarioDao {
    @Test
    public void salvar(){
        Usuario usu =new Usuario();
        usu.setNome("Everton");
        usu.setEmail("Everton.nrb@gmail");
        usu.setSenha("123212");
        usu.setPerfil("ADM");
        UsuarioDao dao = new UsuarioDao();
        dao.salvar(usu);
    }
}
