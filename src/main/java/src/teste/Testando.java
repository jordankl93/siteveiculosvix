/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import src.model.Veiculo;
import src.dao.VeiculoDAO;

/**
 *
 * @author 20112BSI0016
 */
public class Testando {
    
    public static void main(String[] args){
        VeiculoDAO obj = new VeiculoDAO();
        
        List<String> lista = obj.listarMarcas();
        
        for(String marca : lista){
            System.out.println(marca);
        }
    }
    
}
