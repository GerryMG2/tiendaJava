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
public class Tienda {
     ArrayList<Producto> ListProducts;
     ArrayList<Proveedor> ListProveedores;
     ArrayList<Factura> ListFacturas;
     String NombreTienda;
    Tienda(String nombre_tienda){
        
        ListProducts = new ArrayList<Producto>();
        ListProveedores = new ArrayList<Proveedor>();
        ListFacturas =  new ArrayList<Factura>();
        NombreTienda = nombre_tienda;
        /*
        hacer conexion con la base de datos,
        por el momento solo usar los arrays. 
        */
    }
    
    /* hara falta crear el metodo que sobreescriba la 
    base de datos cada vez que se modifica, por el momento solo los arrays*/
    public void InsertProduct(Producto ProductIn)
    {
        ListProducts.add(ProductIn);
        System.out.println("Se ha insertado Correctamente");
    }
    
    public void DeleteProduct(String name)
    {
        ListProducts.forEach(new Consumer<Producto>(){
            @Override
            public void accept(final Producto Pro){
                if(Pro.Nombre == name )
                {
                    ListProducts.remove(Pro);
                    System.out.println("Se ha eliminado correctamente");
                }
            }
        });
    }
    
    public void InsertFactura(Factura fac)
    {
        this.ListFacturas.add(fac);
    }
    
    public void ShowTiendaProducts()
    {
        ListProducts.forEach(new Consumer<Producto>(){
            @Override
            public void accept(final Producto Pro){
                Pro.Show();
            }
        });
    }
    
    public void buscarProducts(String name)
    {
        ListProducts.forEach(new Consumer<Producto>(){
            @Override
            public void accept(final Producto Pro){
                if(Pro.Nombre == name)
                {
                    Pro.Show();
                }
            }
        });
    }
    
    public Producto buscarProductsToSell(String name)
    {
        for (Producto p: ListProducts)
        {
            if(name.equals(p.Nombre))
            {
                return p;
            }
        }
        return null;
    }
    
    public void ShowTiendaProveedores()
    {
        ListProveedores.forEach(new Consumer<Proveedor>(){
            @Override
            public void accept(final Proveedor Pro){
                Pro.ShowProveedorNoProducts();
            }
        });
    }
    public void ShowTiendaProveedoresPro()
    {
        ListProveedores.forEach(new Consumer<Proveedor>(){
            @Override
            public void accept(final Proveedor Pro){
                Pro.ShowProveedor();
            }
        });
    }
    
    public void ModifyProduct(String name,Producto proModify)
    {
        ListProducts.forEach(new Consumer<Producto>(){
            @Override
            public void accept(final Producto Pro){
                if(Pro.Nombre.equals(name) )
                {
                    Pro.Cantidad = proModify.Cantidad;
                    Pro.Costo = proModify.Costo;
                    Pro.Nombre = proModify.Nombre;
                    Pro.habilitado = proModify.habilitado;
                    System.out.println("Se ha modificado correctamente.");
                    System.out.println("Nuevo producto: ");
                    Pro.Show();
                }
            }
        });
        
    }
    
    public void CargarProduct(Producto ProCargar)
    {
        ListProducts.forEach(new Consumer<Producto>(){
            @Override
            public void accept(final Producto Pro){
                if(Pro.Nombre.equals(ProCargar.Nombre) )
                {
                    Pro.Cantidad += ProCargar.Cantidad;
                    System.out.println("Nuevo producto: ");
                    Pro.Show();
                    
                }
            }
        });
    } 
    
    public void DescargarProduct(Producto ProDescargar)
    {
        ListProducts.forEach(new Consumer<Producto>(){
            @Override
            public void accept(final Producto Pro){
                if(Pro.Nombre.equals(ProDescargar.Nombre) )
                {
                    Pro.Cantidad -= ProDescargar.Cantidad;
                    System.out.println("Nuevo producto: ");
                    Pro.Show();
                }
            }
        });
    }
    
    public void DescartarProduct(Producto ProDescartar,boolean bol)
    {
        ListProducts.forEach(new Consumer<Producto>(){
            @Override
            public void accept(final Producto Pro){
                if(Pro.Nombre.equals(ProDescartar.Nombre) )
                {
                    Pro.habilitado = bol;
                    System.out.println("Nuevo producto: ");
                    Pro.Show();
                }
            }
        });
    }
    
    public void InsertProveedor(Proveedor Prove)
    {
        ListProveedores.add(Prove);
        System.out.println("Se ha insertado Correctamente");
    }
    
    public void DeleteProve(String name)
    {
        ListProveedores.forEach(new Consumer<Proveedor>(){
            @Override
            public void accept(final Proveedor Prove){
                if(Prove.Nombre.equals(name) )
                {
                    ListProducts.remove(Prove);
                    System.out.println("Se ha eliminado correctamente");
                }
            }
        });
    }
    
    public void eliminarProductoProveedor(String prove, String pro){
        for (Proveedor provesearch: ListProveedores)
        {
            if(provesearch.Nombre.equals(prove))
            {
                provesearch.DeleteProduct(pro);
            }
        }
    }
    
    public void vender(Factura fac)
    {
        ListFacturas.add(fac);
    }
    
    public boolean existeProducto(String name){
        for (Producto p: ListProducts)
        {
            if(p.Nombre.equals(name))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean existeProveedor(String name){
        for (Proveedor p: ListProveedores)
        {
            if(p.Nombre.equals(name))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean existeProProvee(String provee, String name)
    {
        for (Proveedor prove: ListProveedores)
        {
            if(prove.Nombre.equals(provee))
            {
                for (Producto p: prove.ListaProductos)
                {
                    if(p.Nombre.equals(name))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public String getNombre()
    {
        return this.NombreTienda;
    }
    
    public Proveedor getProveedor(String name)
    {
        for( Proveedor p: ListProveedores)
        {
            if(p.Nombre.equals(name))
            {
                return p;
            }
        }
        return null;
    }
    
    public void ShowFacturas()
    {
        for(Factura f:ListFacturas)
        {
            f.showFactura();
        }
    }
}
