/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jorge
 */
public class Partido {
    
    private int id;
    private String nombre;
    private int votos;

    
    public Partido( String nombre){
        
        this.nombre=nombre;
        
               
    }
    public Partido (int id , String nombre , int votos){
        this(nombre);
        this.id=id;
        this.votos=votos;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
    
    
    
    
}
