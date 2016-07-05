package src.model;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import src.model.*;
import static junit.framework.Assert.assertEquals;

public class VeiculoTest {

    @Test
    public void deveriaVenderUmVeiculo() throws Exception {
        Veiculo veiculo = new Veiculo(new Double(25000), "GM", "Celta", 2015, "Completo", null);
        veiculo.Vender();

        assertEquals(true, veiculo.Vendido());
    }
}
