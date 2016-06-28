/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.backingbean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import src.dao.VeiculoDAO;
import src.model.Veiculo;

/**
 *
 * @author Jordan-PC
 */
@ManagedBean(name = "homeBean")
@SessionScoped
public class HomeBean {
    private String marcaSelecionada;
    private List<String> listaMarcas =  new ArrayList<>();
    private List<Veiculo> listaVeiculos = new ArrayList<>();
    private Veiculo veiculo = new Veiculo();
    private VeiculoDAO veiculoCrud = new VeiculoDAO();
    
    public HomeBean() {
        listaVeiculos = veiculoCrud.listar();
        listaMarcas = veiculoCrud.listarMarcas();
    }

    public String getMarcaSelecionada() {
        return marcaSelecionada;
    }

    public void setMarcaSelecionada(String marcaSelecionada) {
        this.marcaSelecionada = marcaSelecionada;
    }

    public List<String> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(List<String> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }   

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    
    /*Métodos*/
    public String buscarVeiculos(String Marca){
        listaVeiculos = veiculoCrud.listarVeiculosByMarca(Marca);
        return "home";
    }        
    
    public String verListaVeiculos() {
        //popula a lista ...
        listaVeiculos = veiculoCrud.listar();
        //... e apresenta uma tabela com os registros
        return "home";
    }    
    
}
