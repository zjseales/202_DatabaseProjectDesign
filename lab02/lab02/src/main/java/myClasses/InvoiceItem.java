/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

/** InvoiceItem.java 
 *  INFO202 Lab02
 *
 *  Basic class representing items for an invoice.
 *
 *@author Zac Seales - 6687905
 */
public class InvoiceItem {

    private String productName;
    private Double salePrice;
    private Double quantityPurchased;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(Double quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    /** Returns the total cost of this item.
     *
     *@return - the cost of this InvoiceItem.
     */
    public Double getItemTotal() {
        return salePrice * quantityPurchased;
    }

}
