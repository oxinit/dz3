package PageObjectTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Map;

import static java.lang.Integer.valueOf;
import static org.testng.Assert.assertTrue;
//тут викликаєм методи з пейджів
//послідовність Business requirements
public class BasketTest extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger(BasketTest.class);

    @Test
    @Parameters({"prop1","prop2"})
    public void notAtomicityMethod(String p1, String p2) throws InterruptedException {
        Page().searchFieldSendKeys(p1);//
        logger.info("first step after pre-step ");
        Page().clickFindButton();
        logger.info("press find button ");
        Page().hpCHeckBoxClick();//second
        logger.info("hp check box click");
        Page().expensiveSortClick();//third
        logger.info("sort expensive first ");
        Page().firstElementClick();//fourth
        logger.info("chose first element");
        Page().buyClick();//culmination
        logger.info("click buy");
      // Page().buyBasketClick();
        assertTrue(valueOf(Page().checkSumOfGoods())<valueOf(p2));//check da heart of test
        logger.info("assert went positive");
       // logger.error("Error log message");
    }


}
