/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anothershop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Store store = new Store("Store");
       
       
       store.addNewAdmin("Gary");
       store.addNewSeller("Still Gary");
       Menu menu = new Menu();
       menu.ImplementMenu(store);
  
    }
    
}
