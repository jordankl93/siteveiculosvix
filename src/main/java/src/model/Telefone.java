/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

/**
 *
 * @author Briane
 */
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Telefone")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 7767947424267607077L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    
    @Column(name = "numero", length = 25)
    private String numero;

    public Integer getId() {
        return Id;
    }

    public String getNumero() {
        return numero;
    }
    
    
    
}
