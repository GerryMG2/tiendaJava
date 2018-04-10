/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienditajava;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 *
 * @author gerar
 */
public class Proveedor {
    String Nombre;
    String Numero;
    ArrayList<Producto> ListaProductos;
    
    Proveedor(String name, String num){
        ListaProductos = new ArrayList();
        Nombre = name;
        Numero = num;
        /*conexion a base de datos*/
    }
    
    public boolean TieneEseProducto(Producto pro){
        for (Producto proCompare: ListaProductos)
        {
            if(pro.Nombre.equals(proCompare.Nombre))
            {
                return true;
            }
        }
        return false;
    }
    
    public void InsertProduct(Producto Pro)
    {
        ListaProductos.add(Pro);
        System.out.println("Se ha insertado correctamente");
    }
    
    public void DeleteProduct(String name)
    {
        ListaProductos.forEach(new Consumer<Producto>(){
            @Override
            public void accept(final Producto Pro){
                if(Pro.Nombre.equals(name) )
                {
                    ListaProductos.remove(Pro);
                    System.out.println("Se ha eliminado correctamente");
                }
            }
        });
    }
    
    public String GetNumber()
    {
        return Numero;
    }
    
    public String GetNombre()
    {
        return Nombre;
    }
    
    public void ShowProveedor()
    {
        System.out.println("Nombre: " + this.Nombre + " || Numero: " + this.Numero);
        System.out.println("lista De poductos que vende: ");
        for (Producto pro: ListaProductos)
        {
            pro.Show();
        }
        System.out.println("#########################################################");
        
    }
    public void ShowProveedorNoProducts()
    {
        System.out.println("Nombre: " + this.Nombre + " || Numero: " + this.Numero);
       
        System.out.println("#########################################################");

    }
    
    public float getCost(String name)
    {
        for (Producto p: ListaProductos)
        {
            if(p.Nombre.equals(name))
            {
                return p.Costo;
            }
        }
        return 0;
    }
    
    public Producto getProduct(String name)
    {
        for (Producto p: ListaProductos)
        {
            if(p.Nombre.equals(name))
            {
                return p;
            }
        }
        return null;
    }
}

