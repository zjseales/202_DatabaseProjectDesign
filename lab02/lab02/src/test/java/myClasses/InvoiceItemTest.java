/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package myClasses;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** InvoiceItemTest.java
 *  INFO202 Lab02
 * 
 *  A test for the InvoiceItem class. 
 *@author Zac Seales - 6687905
 */
public class InvoiceItemTest {
    
    private InvoiceItem item;
    
    @BeforeEach
    public void setUp() {
        //initialize the InvoiceItem object
        item = new InvoiceItem();
        item.setProductName("Arbi trary");
        item.setSalePrice(0.1);
        item.setQuantityPurchased(0.2);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetProductName() {
    }

    @Test
    public void testSetProductName() {
    }

    @Test
    public void testGetSalePrice() {
    }

    @Test
    public void testSetSalePrice() {
    }

    @Test
    public void testGetQuantityPurchased() {
    }

    @Test
    public void testSetQuantityPurchased() {
    }

    @Test
    public void testGetItemTotal() {
        Double result = item.getItemTotal();
        assertThat(result, is(closeTo(0.02, 0.0001)));
    }
    
}
