package com.marcondes;

import java.util.List;

import org.junit.Test;

import com.marcondes.dao.DaoGeneric;
import com.marcondes.model.TelefoneUser;
import com.marcondes.model.UsuarioPessoa;

public class TesteHibernate {
    
    @Test
    public void testeHibernateUtil(){

        // HibernateUtil.gEntityManager();

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

        UsuarioPessoa pessoa = new UsuarioPessoa();

        pessoa.setIdade(25);
        pessoa.setLogin("teste");
        pessoa.setNome("Maria");
        pessoa.setSobrenome("Silva");
        pessoa.setSenha("123456");
        pessoa.setEmail("maria@gmail.com");

        daoGeneric.salvar(pessoa);
    }

    @Test
    public void testeBuscar(){

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
        UsuarioPessoa pessoa = new UsuarioPessoa();

        pessoa.setId(1L);

        pessoa = daoGeneric.pesquisar(pessoa);

        System.out.println(pessoa);
    }

    @Test
    public void testeBuscar2(){

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

        UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);

        System.out.println(pessoa);
    }

    @Test
    public void testeUpdate(){

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

        UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);

        pessoa.setIdade(99);
        pessoa.setNome("Nome atualizado Hibernate");

        daoGeneric.updateMerge(pessoa);

        System.out.println(pessoa);
    }

    @Test
    public void testeDelete(){

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

        UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);

        daoGeneric.deletarPorId(pessoa);

    }

    @Test
    public void testeConsultar(){

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

        List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);

        for (UsuarioPessoa usuarioPessoa : list) {
            System.out.println(usuarioPessoa);
            System.out.println("----------------------------------------------------------------------------------");
        }
    }

    @Test
    public void testeQueryList(){

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

        @SuppressWarnings("unchecked")
        List<UsuarioPessoa> list = daoGeneric.gEntityManager().createQuery("FROM UsuarioPessoa WHERE nome = 'Marcondes'").getResultList();

        for (UsuarioPessoa usuarioPessoa : list) {

            System.out.println(usuarioPessoa);
            System.err.println("--------------------------------------");
            
        }
    }

    @Test
    public void testeQueryListMaxResult(){

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

        @SuppressWarnings("unchecked")
        List<UsuarioPessoa> list = daoGeneric.gEntityManager().createQuery("FROM UsuarioPessoa ORDER BY nome").setMaxResults(2).getResultList();

        for (UsuarioPessoa usuarioPessoa : list) {

            System.out.println(usuarioPessoa);
            System.err.println("--------------------------------------");
            
        }
    }

    @Test
    public void testeQueryListParameter(){

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

        @SuppressWarnings("unchecked")
        List<UsuarioPessoa> list = daoGeneric.gEntityManager().createQuery("FROM UsuarioPessoa WHERE nome = :nome").setParameter("nome", "Marcondes").getResultList();

        for (UsuarioPessoa usuarioPessoa : list) {

            System.out.println(usuarioPessoa);
            
        }
    }

    @Test
    public void testeQuerySomaIdade(){

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

        Long somaIdade = (Long) daoGeneric.gEntityManager().createQuery("SELECT SUM(u.idade) FROM UsuarioPessoa u").getSingleResult();

        System.out.println("Soma de todas as idades: " + somaIdade);
    }

    @Test
    public void testeNamedQuery(){

        DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
        @SuppressWarnings("unchecked")
        List<UsuarioPessoa> list = daoGeneric.gEntityManager().createNamedQuery("UsuarioPessoa.todos").getResultList();

        for (UsuarioPessoa usuarioPessoa : list) {

            System.out.println(usuarioPessoa);
            
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testeGravaTelefone(){

        @SuppressWarnings("rawtypes")
        DaoGeneric daoGeneric = new DaoGeneric();

        UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(2L, UsuarioPessoa.class);

        TelefoneUser telefoneUser = new TelefoneUser();
        telefoneUser.setTipo("celular");
        telefoneUser.setNumero("123456789");
        telefoneUser.setUsuarioPessoa(pessoa);

        daoGeneric.salvar(telefoneUser);
    }
}
