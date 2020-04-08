/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anothershop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class CashRegister {
    int currentReceipt=0;
    List<Receipt> receipts = new ArrayList<>();
    String storeName;
   // String fiscallidentifier;
    
    public void startNewSell()
    {
        receipts.add(new Receipt());
    }
    public void ViewSell()
    {
        for(int i=0;i<receipts.get(currentReceipt).receiptItems.size();i++)
        {
            System.out.println(receipts.get(currentReceipt).receiptItems.get(i).GetName());
            System.out.println(receipts.get(currentReceipt).receiptItems.get(i).GetQuant());
            System.out.println(receipts.get(currentReceipt).receiptItems.get(i).GetppUnit());
        }
    }
    public void registerNewProduct(String name,int quantity,Stock stock)
    {
        
        ReceiptItem item = new ReceiptItem();
        item.SetName(name);
        item.SetQuant(quantity);
        for(int i=0;i<stock.stockItems.size();i++)
        {
            
            if(stock.stockItems.get(i).getProductName().equals(name))
            {
               
                item.SetppUnit(stock.stockItems.get(i).getProductPrice());
            }
        }
        
        this.receipts.get(currentReceipt).receiptItems.add(item);
    }
    public void removeProduct(String name)
    {
        for(int i=0;i<receipts.get(currentReceipt).receiptItems.size();i++)
        {
        if(receipts.get(currentReceipt).receiptItems.get(i).GetName().equals(name))
        {
            receipts.get(currentReceipt).receiptItems.remove(i);
        }
        }
    }
    
       public double finalizeSell(Stock stock,Receipt receipt)
    {
        
        for(int i=0;i<stock.stockItems.size();i++)
        {
            for(int j=0;j<receipt.receiptItems.size();j++)
            {
            if(stock.stockItems.get(i).getProductName().equals(receipt.receiptItems.get(j).GetName()))
            {
                stock.stockItems.get(i).quantity = stock.stockItems.get(i).quantity - receipt.receiptItems.get(i).GetQuant();
            }
            }
        }
        
        return receipt.getTotal();
        
    }
    
}
