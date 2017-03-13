/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import entidade.Usuario;
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
    
}
