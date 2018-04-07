/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienditajava;

import java.util.ArrayList;

/**
 *
 * @author gerar
 */
public class Factura {
    String NombreCliente;
    String NombreVendedor;
    ArrayList<Producto> Pro;
    Factura(ArrayList<Producto> venta,String cliente, String vendedor)
    {
        Pro = venta;
        NombreCliente = cliente;
        NombreVendedor = vendedor;
    }
    
    public void showFactura(){
        float total = 0;
        for (Producto pro:Pro)
        {
            float costoparcial = pro.Costo * pro.Cantidad;
            total += costoparcial;
            
            System.out.println("Producto: " + pro.Nombre + " Cantidad: " +  pro.Cantidad + " $" + costoparcial );
            
        }
        System.out.println("Total a pagar: $" + total);
    }
    
    
}
