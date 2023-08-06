package in.gmsk.array;

import org.junit.jupiter.api.Test;

public class BestTimeToBuyAndSellStockTest {

    @Test
    public void maxProfit() {

        BestTimeToBuyAndSellStock instance = new BestTimeToBuyAndSellStock();
        int[] arrayOfAmount = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(instance.maxProfit(arrayOfAmount));
    }
}