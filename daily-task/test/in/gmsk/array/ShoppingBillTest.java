package in.gmsk.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingBillTest {
    @Test
    void displayBillTest(){
        ShoppingBill instance = new ShoppingBill();
        instance.displayBill();
    }
}