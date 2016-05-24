package rocketBase;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	
	public static int testCreditScore;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		testCreditScore = 650;
	}
	
	@AfterClass
	public static void tearDownAfterClass(){
		testCreditScore = (Integer) null;
	}
	
	@Test
	public void testGetRate() {
		assertTrue(RateBLL.getRate(testCreditScore)==4);
	}
	
	@Test
	public void testGetPayment(){
		assertTrue(RateBLL.getPayment(4, 360, 300000, 0, false) == 1432.25 );
	}

}
