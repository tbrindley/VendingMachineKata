package com.pillar;

import com.pillar.coins.Coin;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @Test
    public void readTheWeightOfAPennyToLaterVerifyItsIdentify() throws Exception {
        Coin penny = Coin.getPenny();
        double expected = 2.5;
        double actual = penny.getWeight();

        assertEquals("TestCase 1 Failed:  Penny didn't weight 2.5g",expected, actual, 0.001);
    }


}