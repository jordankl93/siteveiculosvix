/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import src.model.Veiculo;
import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import src.conexao.HibernateUtil;

/**
 *
 * @author Jordan-PC
 */
public class VeiculoDAO {
    
    public void salvar(Veiculo veiculo) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            //abre um sessão com o banco de dados.
            sessao = HibernateUtil.getSessionFactory().openSession();
            //inicia um transacao
            transacao = sessao.beginTransaction();
            //salva o usuário
            sessao.saveOrUpdate(veiculo);
            //confirma a transacao
            transacao.commit();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível inserir um veículo.Erro: " + e.getMessage());
        } finally {
            try {
                //fecha a sessao com o banco de dados
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operacao de veículo.Erro:" + e.getMessage());
            }
        }
    }
    
    public void deletar(Veiculo veiculo){
        Session sessao = null;
        Transaction transacao = null;
        try {
            //abre um sessão com o banco de dados.
            sessao = HibernateUtil.getSessionFactory().openSession();
            //inicia um transacao
            transacao = sessao.beginTransaction();
            //deleta o usuário
            sessao.delete(veiculo);
            //confirma a transacao
            transacao.commit();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível deletar um veículo.Erro: " + e.getMessage());
        } finally {
            try {
                //fecha a sessao com o banco de dados
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operacao de veículo.Erro:" + e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    /**
     *
     * @return List<Usuario>
     *
     * Método retorna uma lista de usuarios
     */
    public List<Veiculo> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Veiculo> resultado = null;
        try {
            //Abre uma sessao no banco de dados
            sessao = HibernateUtil.getSessionFactory().openSession();
            //Inicia uma transacao
            //Mesmo na leitura é bom manter o controle da transação - leia mais: http://www.inf.puc-rio.br/~rogcosta/inf1341/bd3-TransacoesEmAplicacoes.pdf
            transacao = sessao.beginTransaction();
            /*Responsável por montar consultas no Hibernate usando o padrão HQL.
             O hibernate cria um nova linguagem HQL, a sintaxe similar ao SQL.
             Observe que, ao
             passarmos a instrucao SQL para o método, não usamos a tradicional
             instrucao select * from contato, mas
             from Contato. Isso porque agora estamos lidando com objetos, e não
             mais linhas de resultado de uma consulta.
             Tanto que Contato, de from Contato, se refere à nossa classe conforme
             mapeada no arquivo XML
             Mais informacoes: http://www.mkyong.com/hibernate/hibernate-queryexamples-hql/
             */
            consulta = sessao.createQuery("from Veiculo");
            //Retorna lista de contatos
            resultado = consulta.list();
            //Confirma a transacao
            transacao.commit();
            //retona a lista de usuarios
            return resultado;
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível selecionar os Veiculo.Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação consulta.Erro: " + e.getMessage());
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    /**
     *
     * @return List<Usuario>
     *
     * Método retorna uma lista de Marcas
     */
    public List<String> listarMarcas() {
        Session sessao = null;
        Transaction transacao = null;
        List resultado = null;
        try {
            //Abre uma sessao no banco de dados
            sessao = HibernateUtil.getSessionFactory().openSession();            
            transacao = sessao.beginTransaction();
            resultado = sessao.createCriteria(Veiculo.class).setProjection(Projections.projectionList()
                            .add(Projections.groupProperty("marca"))).list();
            //Confirma a transacao
            transacao.commit();
            //retona a lista de marcas
            return resultado;
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível selecionar os Veiculo.Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação consulta.Erro: " + e.getMessage());
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    /*
     * Lista veículos por marca
     */
    public List<Veiculo> listarVeiculosByMarca(String marca) {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Veiculo> resultado = null;
        try {
            //Abre uma sessao no banco de dados
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Veiculo where marca= :parametro");
            consulta.setString("parametro", marca);
            //Retorna lista de contatos
            resultado = consulta.list();
            //Confirma a transacao
            transacao.commit();
            //retona a lista de usuarios
            return resultado;
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível selecionar os Veiculo.Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação consulta.Erro: " + e.getMessage());
            }
        }
    }
    
    /*
     * Busca um usuário pelo código
     */
    public Veiculo buscaVeiculo(int id) {
        Veiculo veiculo = null;
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        try {
            //inicia a sessao
            sessao = HibernateUtil.getSessionFactory().openSession();
            //inicia transacao
            transacao = sessao.beginTransaction();
            //consulta o Usuario
            consulta = sessao.createQuery("from Veiculo where idveiculo= :parametro");
            //atribui o valor do código do usuário como parâmetro da consulta HQL.
            consulta.setInteger("parametro", id);
            //Obtém um único objeto da consulta
            veiculo = (Veiculo) consulta.uniqueResult();
            //confirma transação
            transacao.commit();
            return veiculo;
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível buscar o contato.Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação buscar. Erro: " + e.getMessage());
            }
        }
    }
}
