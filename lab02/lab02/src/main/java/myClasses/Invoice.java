/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

/** Invoice.java
 *  INFO202 Lab02
 * 
 *  A basic invoice domain class. 
 *@author Zac Seales - 6687905
 */
public class Invoice {
    
    private String customerName;
    private String customerAddress;
    private LocalDate date;
    
    private static Collection<InvoiceItem> items = new HashSet<>();

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Collection<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(Collection<InvoiceItem> items) {
        this.items = items;
    }
    
    
    
    /** Adds the item parameter to the items list.
     *@param itemToAdd - the item being added.
     */
    public void addItem(InvoiceItem itemToAdd){
        items.add(itemToAdd);
    }
    
    /** Removes the item parameter from the items list.
     *@param itemToRemove - the item being removed.
     */
    public void removeItem(InvoiceItem itemToRemove){
        items.remove(itemToRemove);
    }
    
    /** Returns the total price of all InvoiceItem objects in the]
     *  items list.
     *@return - the subtotal of the items list contents.
     */
    public Double getTotal(){
        Double total = 0.0;
        for (InvoiceItem i : items){
            total += i.getItemTotal();
        }
        return total;
    }
    
    
    
}
