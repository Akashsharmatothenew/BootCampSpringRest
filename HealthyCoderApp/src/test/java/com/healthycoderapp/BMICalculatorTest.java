package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Created by ttn on 26/2/21.
 */
class BMICalculatorTest {

       @Test
       void ShouldReturnTrueWhenDietRecommend(){
              assertTrue(BMICalculator.isDietRecommended(89.0,1.72));
       }


}