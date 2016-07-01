package src.dao;

import java.util.List;
import org.hibernate.*;
import src.conexao.HibernateUtil;
import src.model.Endereco;


public class EnderecoDAO {
    public boolean salvar(Endereco endereco) {
        boolean retorno = true;
        Session sessao = null;
        Transaction transacao = null;
        try {
            //abre um sessão com o banco de dados.
            sessao = HibernateUtil.getSessionFactory().openSession();
            //inicia um transacao
            transacao = sessao.beginTransaction();
            //salva o usuário
            sessao.saveOrUpdate(endereco);
            //confirma a transacao
            transacao.commit();
        } catch (HibernateException e) {
            retorno = false;
            throw new ExceptionInInitializerError("Não foi possível inserir um endereco. Erro: " + e.getMessage());
        } finally {
            try {
                //fecha a sessao com o banco de dados
                sessao.close();
            } catch (Throwable e) {
                retorno = false;
                throw new ExceptionInInitializerError("Erro ao fechar a operacao de endereco.Erro:" + e.getMessage());
            }
        }
        return retorno;
    }
    
    public void deletar(Endereco endereco){
        Session sessao = null;
        Transaction transacao = null;
        try {
            //abre um sessão com o banco de dados.
            sessao = HibernateUtil.getSessionFactory().openSession();
            //inicia um transacao
            transacao = sessao.beginTransaction();
            //deleta o usuário
            sessao.delete(endereco);
            //confirma a transacao
            transacao.commit();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível deletar um endereco. Erro: " + e.getMessage());
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
     * @return List<Endereco>
     *
     * Método retorna uma lista de propostas
     */
    public List<Endereco> listar() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Endereco> resultado = null;
        try {
            //Abre uma sessao no banco de dados
            sessao = HibernateUtil.getSessionFactory().openSession();
            //Inicia uma transacao
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Endereco");
            resultado = consulta.list();
            //Confirma a transacao
            transacao.commit();
            //retona a lista de enderecos
            return resultado;
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError("Não foi possível selecionar os Enderecos.Erro: " + e.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Throwable e) {
                throw new ExceptionInInitializerError("Erro ao fechar a operação consulta.Erro: " + e.getMessage());
            }
        }
    }
}

