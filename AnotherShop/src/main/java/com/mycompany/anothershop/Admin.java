/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anothershop;

/**
 *
 * @author Alex
 */
public class Admin extends EmployeeInfo{
    //EmployeeInfo employeeInfo;
    public Admin(String name)
    {
        this.name = name;
    }
    public void addProductsToStock(Stock stock,Product product,int quantity)
    {
        stock.Add(product, quantity);
    }
   public  int checkProductStock(Stock stock,Product product)
    {
        int noItems = 0;
        for(int i=0;i<stock.stockItems.size();i++)
        {
            if(stock.stockItems.get(i).getProductName().equals(product.getProductName()))
            {
                if(stock.stockItems.get(i).quantity>0)
                    noItems = stock.stockItems.get(i).getQuantity();
            }  
        }
        return noItems;
    }
   
   public  Product checkProducts(Stock stock)
    {
        Product noItems = new Product();
        for(int i=0;i<stock.stockItems.size();i++)
        {
           
                if(stock.stockItems.get(i).quantity>0)
                {
                    noItems = stock.stockItems.get(i).getProduct();
                    System.out.println(noItems.getProductName());
                    System.out.println(noItems.getProductPrice());
                }
        }
        return noItems;
    }
   
   
    public void removeProductsFromStock(Stock stock,StockItem product)
    {
        
         for(int i=0;i<stock.stockItems.size();i++)
         {
             if(stock.stockItems.get(i).getProductName().equals(product.getProductName()))
             {
                 stock.stockItems.remove(stock.stockItems.get(i));
             }
         }
    }
}
