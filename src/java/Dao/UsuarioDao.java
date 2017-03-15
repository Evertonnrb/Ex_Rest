/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidade.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author everton
 */
public class UsuarioDao {
    
    
    public void salvar(Usuario usu){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction trasacao = null;
        try {
            trasacao = sessao.beginTransaction();
            sessao.save(usu);
            trasacao.commit();
        } catch (Exception e) {
            if(trasacao!=null){
                trasacao.rollback();
                System.err.println("Erro "+e);
            }
        }finally{
           sessao.close();
        }
    }
  public List<Usuario> listar(){
      
      Session sessao = HibernateUtil.getSessionFactory().openSession();
      List<Usuario> usuarios = null;
      
      try {
          Query consulta = sessao.getNamedQuery("Usuario.listar");
          usuarios = consulta.list();
      } catch (RuntimeException e) {
          throw new RuntimeException(e);
                  
      }finally{
          sessao.close();
      }
      return usuarios;
  }
  public Usuario buscar(String email){
      Session sessao = HibernateUtil.getSessionFactory().openSession();
      Usuario usu = null;
      try {
          Query consulta = sessao.getNamedQuery("Usuario.buscarPorEmail");
          consulta.setString("email", email);
          usu = (Usuario) consulta.uniqueResult();
      } catch (RuntimeException e) {
          throw e;
      }
      return usu;
  }
  public Usuario login(String email, String senha){
      Session sessao = HibernateUtil.getSessionFactory().openSession();
      Usuario usu = null;
      try {
          Query consulta = sessao.getNamedQuery("buscarEmailSenha");
          consulta.setString("email", senha);
          consulta.setString("senha", senha);
          usu = (Usuario) consulta.uniqueResult();
      } catch (RuntimeException e) {
          throw e;
      }finally{
          sessao.close();
      }
      return usu;
  }
}
