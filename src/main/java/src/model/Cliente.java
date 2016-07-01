///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package src.model;
//
///**
// *
// * @author Briane
// */
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Cliente")
//public class Cliente {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Id")
//    private Integer Id;
//    
//    @Column(name = "nome", length = 200)
//    private String nome;
//    
//    @Column(name = "email", length = 200)
//    private String email;
//    
//    @Column(name = "IdEndereco")
//    private int IdEndereco;
//
//    public Cliente(String nome, String email, int IdEndereco) {
//        this.nome = nome;
//        this.email = email;
//        this.IdEndereco = IdEndereco;
//    }
//
//    
//    
//    public Integer getId() {
//        return Id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public int getIdEndereco() {
//        return IdEndereco;
//    }
//    
//    
//   
//}
