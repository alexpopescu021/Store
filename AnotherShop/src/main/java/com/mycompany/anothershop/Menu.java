/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anothershop;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Menu implements IMenu{
    @Override
    public void ImplementMenu(Store store) {
    
        boolean app = true;
        while(app)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("0. Exit  1. Use as administrator 2. Use as seller");
            int choice = scanner.nextInt();
            
            switch(choice)
            {
                case 0: // Exit
                {
                    app = false;
                    break;
                }
                
                case 1: // Use as administrator
                {
                    boolean screen1 = true;
                    while(screen1)
                    {
                        Scanner in1 = new Scanner(System.in);
                        
                        System.out.println("0. Back  1. Stock  2. Cash registers");
                        int choice1 = in1.nextInt();
                    
                        switch(choice1)
                        {
                            case 0: // Back
                            {
                                screen1 = false;
                                break;
                            }
                            
                            case 1: // Stock
                            {
                                boolean screen2 = true;
                                while(screen2)
                                {
                                    Scanner in2 = new Scanner(System.in);
                                    System.out.println("0. Back  1. Add product  2. Remove product  3. View Stock");
                                    int choice2 = in2.nextInt();
                                    
                                    switch(choice2)
                                    {
                                        case 0: // Back
                                        {
                                            screen2 = false;
                                            break;
                                        }
                                        
                                        case 1: // Add a product
                                        {
                                            Product product = new Product();
                                            Scanner scanner1 = new Scanner(System.in);
                                            System.out.println("Input the information about the product (name, price, quantity)");
                                            
                                            String name = scanner1.nextLine();
                                            
                                            double price = scanner1.nextDouble();
                                            product.setProduct(name, price);
                                            int quant = scanner1.nextInt();
                                            store.admins.get(0).addProductsToStock(store.stock, product, quant);
                                            break;
                                        }
                                        
                                        case 2: // Remove product
                                        {
                                            System.out.println("Input the name of the product you want to remove");
                                            StockItem product = new StockItem();
                                            Scanner scanner1 = new Scanner(System.in);
                                            String name = scanner1.nextLine();
                                            product.setProductName(name);
                                            store.admins.get(0).removeProductsFromStock(store.stock, product);
                                            break;
                                        }
                                        
                                        case 3: // View stock
                                        {
                                            store.admins.get(0).checkProducts(store.stock);
                                            break;
                                        }
                                    }
                                }
                                
                                break;
                            }
                            
                            case 2: // Cash registers
                            {
                                boolean screen3 = true;
                                while(screen3)
                                {
                                    Scanner in3 = new Scanner(System.in);
                                    System.out.println("0. Back  1. Add cash register  2. Remove cash register  3. View cash registers");
                                    int choice3 = in3.nextInt();
                                    
                                    switch(choice3)
                                    {
                                        case 0: // Back
                                        {
                                            screen3 = false;
                                            break;
                                        }
                                        
                                        case 1: // Add cash register
                                        {
                                            store.cashRegisters.add(new CashRegister());
                                            break;
                                        }
                                        
                                        case 2: // Remove cash register
                                        {
                                            System.out.println("Choose the index of the cash register to remove");
                                            int i = scanner.nextInt();
                                            store.cashRegisters.remove(i);
                                            break;
                                        }
                                        
                                        case 3: // View cash registers
                                        {
                                            for(int i=0;i<store.cashRegisters.size();i++)
                                            {
                                                System.out.println(store.cashRegisters.get(i));
                                            }
                                            break;
                                        }
                                    }
                                }
                                
                                break;
                            }
                        }
                    }
                    
                    break;
                }
                
                case 2: // Use as seller
                {
                    boolean screen4 = true;
                    while(screen4)
                    {
                        Scanner in4 = new Scanner(System.in);
                        System.out.println("0. Back  1. Start sell  2. Search product  3. View stock");
                        int choice4 = in4.nextInt();
                    
                        switch(choice4)
                        {
                            case 0:
                            {
                                screen4 = false;
                                break;
                            }
                            
                            case 1: // Start sell
                            {
                                 store.cashRegisters.get(0).startNewSell();
                                boolean screen5 = true;
                                while(screen5)
                                {
                                    Scanner in5 = new Scanner(System.in);
                                    System.out.println("0. Back  1. Add product to sell  2. Remove product  3. View current sell  4. Finalize sell");
                                    int choice5= in5.nextInt();
                                    
                                    switch(choice5)
                                    {
                                        case 0: // Back
                                        {
                                            screen5 = false;
                                            break;
                                        }
                                        
                                        case 1: // Add product to sell
                                        {
                                            Scanner in6 = new Scanner(System.in);
                                            System.out.println("Name of the product");
                                            String name = in6.nextLine();
                                            System.out.println("How many of them?");
                                             int quant = in6.nextInt();
                                         if(store.sellers.get(0).checkProductStock(store.stock, name,quant)== -1)
                                        {
                                            System.out.println("We don't have that product anymore in stock");
                                            break;
                                        }
                                       store.cashRegisters.get(0).registerNewProduct(name,quant,store.stock);
                                            break;
                                        }
                                        
                                        case 2: // Remove product
                                        {
                                            System.out.println("Name of the product");
                                            String name = scanner.nextLine();
                                            store.cashRegisters.get(0).removeProduct(name);
                                            break;
                                        }
                                        
                                        case 3: // View current sell
                                        {
                                           store.cashRegisters.get(0).ViewSell();
                                        }
                                        
                                        case 4: // Finalize sell
                                        {
                                           
                                            double total = store.cashRegisters.get(0).finalizeSell(store.stock, store.cashRegisters.get(0).receipts.get(store.cashRegisters.get(0).currentReceipt));
                                            System.out.println(total);
                                            break;
                                        }
                                    }
                                }
                                
                                break;
                            }
                            
                            case 2: // Search product
                            {
                                Scanner in7 = new Scanner(System.in);
                                            System.out.println("Name of the product");
                                            String name = in7.nextLine();
                                store.stock.Search(name);
                                break;
                            }
                            
                            case 3: // View stock
                            {
                                store.stock.View();
                                break;
                            }
                        }    
                    }
                    
                    break;
                }
            }
        }
    } 
}
