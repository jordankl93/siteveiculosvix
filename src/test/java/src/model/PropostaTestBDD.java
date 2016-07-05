/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import static org.junit.Assert.*;
import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import src.model.Proposta;

/**
 *
 * @author Jordan-PC
 */
public class PropostaTestBDD {

    public PropostaTestBDD() {
    }

    private Proposta proposta;

    @Given("^the send a new \"(.*?)\"$")
    public void thePriceOfAIsC(String name) throws Throwable {
        proposta = new Proposta();
    }

    @When("^I \"(.*?)\"$")
    public void iCheckout(String itemName) throws Throwable {
        if(itemName.equals("accept")){
            proposta.Aceitar(true);
        }
    }

    @Then("^the proposta accept should be true$")
    public void theTotalPriceShouldBeC() throws Throwable {
        assertEquals(true, proposta.Aceita());
    }
    
}
