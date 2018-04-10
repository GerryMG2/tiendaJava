/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienditajava;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gerar
 */
public class Menu {
    Administrador admin;
    Tienda tienda;
    
    Menu()
    {
        admin = new Administrador("admin","admin");
        tienda = new Tienda("Maria's");
    }
    
    public void iniciar()
    {
        
        boolean terminar = false;
        
        int opcion;
        while(terminar == false)
        {
            System.out.println("1.Lista De Productos 2.Lista de Proveedores 3.Hacer Pedido 4.Agregar Producto  ");
            System.out.println("5.Modificar Producto 6. Eliminar Producto 7. Agregar Proveedor 8. Eliminar Proveedor ");
            System.out.println("8. Ver todos los productos de los proveedores 9.BuscarProveedor 10. Buscar Producto 11.Vender 12. Mostrar facturas");
            System.out.println("Ingrese una opcion: ");
            Scanner input = new Scanner(System.in);
            opcion = input.nextInt();
            
            switch(opcion)
            {
                case 1:
                    tienda.ShowTiendaProducts();
                    break;
                case 2:
                    tienda.ShowTiendaProveedores();
                    break;
                case 3:
                    tienda.ShowTiendaProveedoresPro();
                    ArrayList<Producto> subPro = new ArrayList<Producto>();
                    System.out.println("Ingrese el Nombre del Proveedor: ");
                    String proveedor3 = input.next();
                    while(true)
                    {
                        
                        System.out.println("Nombre del Producto: ");
                        String Producto3 = input.next();
                        System.out.println("Ingrese la cantidad del producto: ");
                        int cantidad3 = input.nextInt();
                        
                        if(tienda.existeProProvee(proveedor3, Producto3) && tienda.getProveedor(proveedor3).getProduct(Producto3).getCantidad() >= cantidad3){
                            tienda.getProveedor(proveedor3).getProduct(Producto3).Cantidad -= cantidad3;
                            Proveedor auxProv = tienda.getProveedor(proveedor3);
                            float costo = auxProv.getCost(Producto3);
                            Producto aux = new Producto(cantidad3,Producto3,costo);
                            if(tienda.existeProducto(aux.Nombre))
                            {
                                tienda.CargarProduct(aux);
                            }
                            else
                            {
                                tienda.InsertProduct(aux);
                            }
                            subPro.add(aux);
                        }
                        else
                        {
                            System.out.println("El proveedor o el producto no existe");
                            break;
                        }
                        
                        System.out.println("Digite 1 para pedir otro producto: ");
                        int auxOpcion = input.nextInt();
                        if(auxOpcion != 1)
                        {
                            break;
                        }
                            
                    }
                    if(!subPro.isEmpty())
                    {
                        Factura facAux = new Factura(subPro,tienda.NombreTienda,proveedor3);
                        System.out.println("La compra se hizo exitosamente");
                        facAux.showFactura();
                        tienda.InsertFactura(facAux);
                    }
                    else{
                        System.out.println("No hay productos que comprar");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del producto: ");
                    String producto4 = input.next();
                    System.out.println("Ingrese la cantidad del producto: ");
                    int cantidad4 = input.nextInt();
                    System.out.println("Ingrese el costo del producto: ");
                    float costo4 = input.nextFloat();
                    if(tienda.existeProducto(producto4))
                    {
                        System.out.println("El Producto ya existe");
                    }
                    else
                    {
                        Producto ProAux = new Producto(cantidad4, producto4,costo4);
                        tienda.InsertProduct(ProAux);
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del producto a modificar: ");
                    String producto5 = input.next();
                    if(tienda.existeProducto(producto5)){
                        System.out.println("Ingrese el nombre del nuevo producto: ");
                        String producto5new = input.next();
                        System.out.println("Ingrese la cantidad del nuevo producto: ");
                        int cantidad5 = input.nextInt();
                        System.out.println("Ingrese el costo del nuevo producto: ");
                        float costo5 = input.nextFloat();
                        Producto proModify = new Producto(cantidad5, producto5new,costo5);
                        tienda.ModifyProduct(producto5, proModify);
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del producto a eliminar: ");
                    String producto6 = input.next();
                    tienda.DeleteProduct(producto6);
                    break;
                case 7: 
                    System.out.println("Ingrese el nombre del nuevo proveedor: ");
                    String proveedor7 = input.next();
                    System.out.println("Ingrese el numero del proveedor");
                    String numero7 = input.next();
                    Proveedor proaux = new Proveedor(proveedor7,numero7);
                    while(true)
                    {
                        System.out.println("Ingrese el nombre del producto: ");
                        String producto7 = input.next();
                        System.out.println("Ingrese la cantidad del producto: ");
                        int cantidad7 = input.nextInt();
                        System.out.println("Ingrese el costo del producto: ");
                        float costo7 = input.nextFloat();
                        Producto aux7 = new Producto(cantidad7, producto7, costo7);
                        proaux.InsertProduct(aux7);
                        System.out.println("Si quiere agregar otro producto digite 1: ");
                        int opcion7 = input.nextInt();
                        if(opcion7 == 1)
                        {
                            
                        }
                        else
                        {
                            break;
                        }
                    }
                    tienda.InsertProveedor(proaux);
                   break;
                case 8:
                    tienda.ShowTiendaProveedoresPro();
                    break;
                case 9:
                    System.out.println("Ingrese el nombre del proveedor: ");
                    String nombre9 = input.next();
                    if(tienda.existeProveedor(nombre9))
                    {
                        Proveedor aux9 = tienda.getProveedor(nombre9);
                        aux9.ShowProveedor();
                    }
                    
                    break;
                case 10:
                    System.out.println("Ingrese el nombre del Producto: ");
                    String nombre10 = input.next();
                    if(tienda.existeProducto(nombre10))
                    {
                        tienda.buscarProducts(nombre10);
                    }
                    break;
                case 11:
                    System.out.println("Ingrese el nombre del cliente");
                    String cliente11 = input.next();
                    
                     tienda.ShowTiendaProducts();
                    ArrayList<Producto> subPro11 = new ArrayList<Producto>();
                    while(true)
                    {
                        
                        System.out.println("Nombre del Producto: ");
                        String Producto11c = input.next();
                        System.out.println("Ingrese la cantidad del producto: ");
                        int cantidad11 = input.nextInt();
                        
                        if(tienda.existeProducto(Producto11c)){
                            float costo = tienda.buscarProductsToSell(Producto11c).getCosto();
                            Producto aux = new Producto(cantidad11,Producto11c,costo);
                            tienda.DescargarProduct(aux);
                            subPro11.add(aux);
                        }
                        else
                        {
                            System.out.println("el producto no existe");
                            break;
                        }
                        
                        System.out.println("Digite 1 para pedir otro producto: ");
                        int auxOpcion = input.nextInt();
                        if(auxOpcion != 1)
                        {
                            break;
                        }
                            
                    }
                    if(!subPro11.isEmpty())
                    {
                        Factura facAux = new Factura(subPro11,cliente11,tienda.NombreTienda);
                        System.out.println("La venta se hizo exitosamente");
                        facAux.showFactura();
                        tienda.InsertFactura(facAux);
                    }
                    
                    break;
                case 12:
                    tienda.ShowFacturas();
            }
            
            System.out.println("Si desea cerrar el sistema digite 1, sino otro numero");
            int term = input.nextInt();
            if(term == 1)
            {
                terminar = true;
            }
            
            
        }
    }
    
    
    
    
}
