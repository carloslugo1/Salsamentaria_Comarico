/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

/**
 *
 * @author User
 */
public class Estado {
     private int Cod_proveedor;
    private String nombre;
    
    public Estado(int Cod_proveedor, String nombre) {
        setCod_proveedor(Cod_proveedor);
        setNombre(nombre);
    }

    public int getCod_proveedor() {
        return Cod_proveedor;
    }

    public void setCod_proveedor(int Cod_proveedor) {
        this.Cod_proveedor = Cod_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString(){
       return this.nombre;
    }
 
}
