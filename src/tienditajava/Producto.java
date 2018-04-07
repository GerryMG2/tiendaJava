/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienditajava;

/**
 *
 * @author gerar
 */
public class Producto {
    

    public Producto(int Cantidad, String Nombre, float Costo) {
        this.Cantidad = Cantidad;
        this.Nombre = Nombre;
        this.Costo = Costo;
        this.IdIntern += 1;
        this.Id = this.IdIntern;
        this.habilitado = true;
    }
    
    
    
    static int IdIntern;
    int Id;
    int Cantidad;
    String Nombre;
    float Costo;
    boolean habilitado;

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public float getCosto() {
        return Costo;
    }

    public void setCosto(float Costo) {
        this.Costo = Costo;
    }
    
    public int getId(){
        return this.Id;
    }
    
    public void Inhabilitar()
    {
        this.habilitado = false;
    }
    
    public void habilitar()
    {
        this.habilitado = true;
    }
    
    public void Show(){
        System.out.println("Nombre: " + this.Nombre + " || Cantidad: " + this.Cantidad + " || Costo: " + this.Costo + " || Habilitado: " + this.habilitado);
    }
    
}
