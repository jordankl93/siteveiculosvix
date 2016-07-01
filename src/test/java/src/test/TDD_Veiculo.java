package src.test;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import src.model.*;

public class TDD_Veiculo {

    @Test
    public void deveriaVenderUmVeiculo() throws Exception {
        Veiculo veiculo = new Veiculo(new Double(25000), "GM", "Celta", 2015, "Completo", null);
        veiculo.Vender();

        assertEquals(true, veiculo.Vendido());
    }
}
