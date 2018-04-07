/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienditajava;

import java.util.Scanner;

/**
 *
 * @author gerar
 */
public class TienditaJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner inputMenu = new Scanner(System.in);
       Menu menu = new Menu();
       while(true)
       {
           System.out.println("Digite la contrasennia(admin): ");
           String pass = inputMenu.next();
           if(menu.admin.isvalid(pass))
           {
               break;
           }
           
       }
       menu.iniciar();
        
        // TODO code application logic here
        
    }
    
}
