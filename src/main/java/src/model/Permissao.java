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
@Table(name = "permissao")
public class Permissao implements Serializable {

    private static final long serialVersionUID = 2795149542016450713L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "Idfuncionario")
    private int Idfuncionario;
    
    @Column(name = "IdTipo_Permissao")
    private int IdTipo_Permissao;

    public Integer getId() {
        return Id;
    }

    public int getIdfuncionario() {
        return Idfuncionario;
    }

    public int getIdTipo_Permissao() {
        return IdTipo_Permissao;
    }
    
    
}
