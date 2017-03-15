/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author everton
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Usuario.listar",query = "SELECT usuario FROM Usuario usuario"),
    @NamedQuery(name = "Usuario.buscarPorEmail", query = "SELECT usuario FROM Usuario usuario WHERE usuario.email=:email"),
    @NamedQuery(name = "Usuario.buscarEmailSenha", query = "SELECT usuario FROM Usuario usuario WHERE usuario.email, usuario.senha=:email,senha")
})//TODO find bug in namedQuery 
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    @Column(length = 50)
    private String nome;
    @Column(length = 50)
    private String email;
    @Column(length = 32)
    private String senha;
    @Column(length = 30)
    private String perfil;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
}
