package com.tests;

import com.utilities.Driver;
import org.testng.annotations.Test;

public class Day09_C4_FirstDriverTest {
/*  Amazon'a git
    title'in 'Amazon'u icerdigini verify et-
    Driver class calistigini check et
*/
    @Test
    public void amazonTitleTest(){
        //Amazona git
        Driver.getDriver().get("https://www.amazon.com");



    }

}
