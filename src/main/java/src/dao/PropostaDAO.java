/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import java.util.List;
import org.hibernate.*;
import src.conexao.HibernateUtil;
import src.model.Proposta;

/**
 *
 * @author Jordan-PC
 */
public class PropostaDAO {
    public boolean salvar(Proposta proposta) {
        boolean retorno = true;
        Session sessao = null;
        Transaction transacao = null;
        try {
            //abre um sessão com o banco de dados.
            sessao = HibernateUtil.getSessionFactory().openSession();
            //inicia um transacao
            transacao = sessao.beginTransaction();
            //salva o usuário
            sessao.saveOrUpdate(proposta);
            //confirma a transacao
            transacao.commit();
        } catch (HibernateException e) {
            retorno = false;
            throw new ExceptionInInitializerError("Não foi possível inserir uma proposta.Erro: " + e.getMessage());
        } finally {
            try {
                //fecha a sessao com o banco de dados
                sessao.close();
            } catch (Throwable e) {
                retorno = false;
                throw new ExceptionInInitializerError("Erro ao fechar a operacao de proposta.Erro:" + e.getMessage());
            }
        }
        return retorno;
    }
    
    public void deletar(Proposta proposta){
        Session sessao = null;
        Transaction transacao = null;
        try {
            //abre um sessão com o banco de dados.
            sessao = HibernateUtil.getSessionFactory().openSession();
            //inicia um transacao
            transacao = sessao.beginTransaction();
            //deleta o usuário
            sessao.delete(proposta);
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
     * @return List<Proposta>
     *
     * Método retorna uma lista de propostas
     */
    public List<Proposta> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Proposta> resultado = null;
        try {
            //Abre uma sessao no banco de dados
            sessao = HibernateUtil.getSessionFactory().openSession();
            //Inicia uma transacao
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Proposta");
            resultado = consulta.list();
            //Confirma a transacao
            transacao.commit();
            //retona a lista de propostas
            return resultado;
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível selecionar as Propostas.Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação consulta.Erro: " + e.getMessage());
            }
        }
    }
}
