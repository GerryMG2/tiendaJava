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
public class Administrador {
    String NombreUsuario;
    String code;

    public Administrador(String NombreUsuario, String code) {
        this.NombreUsuario = NombreUsuario;
        this.code = code;
    }
    
    
    
    public boolean isvalid(String pass)
    {
        if(code.equals(pass))
        {
            return true;
        }
        else{
            return false;
        }
    }
}
