/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import src.model.Veiculo;
import static junit.framework.Assert.assertEquals;

/**
 *
 * @author Jordan-PC
 */
public class VeiculoDAOTest {
    
    private VeiculoDAO veiculoDAO;
    private Veiculo veiculo;
    
     @Before
    public void before() {
        this.veiculoDAO = new VeiculoDAO();
        this.veiculo = new Veiculo();
    }
    
    @Test
    public void testListaVeiculosByMarca() throws Exception {
        List<Veiculo> listaVeiculos = veiculoDAO.listarVeiculosByMarca("Fiat");
        
        assertEquals(2, listaVeiculos.size());
        assertTrue(listaVeiculos.get(0).getMarca().contains("Fiat"));
    }
}
