package src.test;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import src.model.*;

public class TDD_Proposta {

    @Test
    public void deveriaAceitarUmaProposta() throws Exception {
        Endereco endereco = new Endereco("Rua", "Serra", "292500300", "ES", "Brasil");
        //Cliente não existe mais no contexto de cadastro
        //Cliente cliente = new Cliente("Jordan", "Jordan@email.com", 1);
        Veiculo veiculo = new Veiculo(new Double(25000), "GM", "Celta", 2015, "Completo", null);
        Proposta proposta = new Proposta("Pago 24500 no carro.", "Paulo", "Paulo@email", "999-9999", veiculo);

        proposta.Aceitar(true);

        assertEquals(true, proposta.Aceita());
    }
}
