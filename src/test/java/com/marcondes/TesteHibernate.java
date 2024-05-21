package com.marcondes;

import org.junit.Test;

import com.marcondes.dao.DaoGeneric;
import com.marcondes.model.UsuarioPessoa;

public class TesteHibernate {
    
    @Test
    public void testeHibernateUtil(){

        // HibernateUtil.gEntityManager();

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

        UsuarioPessoa pessoa = new UsuarioPessoa();

        pessoa.setIdade(22);
        pessoa.setLogin("teste");
        pessoa.setNome("Marcondes");
        pessoa.setSobrenome("Goncalves");
        pessoa.setSenha("123456");
        pessoa.setEmail("marcondes@gmail.com");

        daoGeneric.salvar(pessoa);
        
    }
}
