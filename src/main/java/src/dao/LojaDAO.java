package src.dao;

import java.util.List;
import org.hibernate.*;
import src.conexao.HibernateUtil;
import src.model.Loja;


public class LojaDAO {
    public boolean salvar(Loja loja) {
        boolean retorno = true;
        Session sessao = null;
        Transaction transacao = null;
        try {
            //abre um sessão com o banco de dados.
            sessao = HibernateUtil.getSessionFactory().openSession();
            //inicia um transacao
            transacao = sessao.beginTransaction();
            //salva o usuário
            sessao.saveOrUpdate(loja);
            //confirma a transacao
            transacao.commit();
        } catch (HibernateException e) {
            retorno = false;
            throw new ExceptionInInitializerError("Não foi possível inserir uma loja. Erro: " + e.getMessage());
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
    
    public void deletar(Loja loja){
        Session sessao = null;
        Transaction transacao = null;
        try {
            //abre um sessão com o banco de dados.
            sessao = HibernateUtil.getSessionFactory().openSession();
            //inicia um transacao
            transacao = sessao.beginTransaction();
            //deleta o usuário
            sessao.delete(loja);
            //confirma a transacao
            transacao.commit();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível deletar uma loja. Erro: " + e.getMessage());
        } finally {
            try {
                //fecha a sessao com o banco de dados
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operacao de loja. Erro:" + e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    /**
     *
     * @return List<Loja>
     *
     * Método retorna uma lista de propostas
     */
    public List<Loja> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Loja> resultado = null;
        try {
            //Abre uma sessao no banco de dados
            sessao = HibernateUtil.getSessionFactory().openSession();
            //Inicia uma transacao
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Loja");
            resultado = consulta.list();
            //Confirma a transacao
            transacao.commit();
            //retona a lista de lojas
            return resultado;
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível selecionar as Lojas.Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação consulta.Erro: " + e.getMessage());
            }
        }
    }
}
