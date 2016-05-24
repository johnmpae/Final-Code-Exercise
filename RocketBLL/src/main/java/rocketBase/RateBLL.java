package rocketBase;

import java.util.ArrayList;
import org.apache.poi.ss.formula.functions.*;

import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) 
	{
		@SuppressWarnings("null")
		double foundRate = (Double) null;// reference code, creates local variable.
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		
		
		//TODO - RocketBLL RateBLL.getRate
		//			obviously this should be changed to return the determined rate
		//return 0;
		ArrayList<RateDomainModel> possibleList = RateDAL.getAllRates();// reach unreachable code
		for (int i = 0; i<possibleList.size(); i++){
			if(possibleList.get(i).getiMinCreditScore()>GivenCreditScore & i != 0){//test rate against credit condition
				foundRate = possibleList.get(i-1).getdInterestRate();
			}
			if(i == 0 && possibleList.get(i).getiMinCreditScore()>GivenCreditScore){
				foundRate = possibleList.get(0).getdInterestRate();
			}
		break;
		}
		return foundRate;
		
	}
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double rate, double numberOfPeriods, double presentValue, double futureValue, boolean t)
	{		
		return FinanceLib.pmt(rate, numberOfPeriods, presentValue, futureValue, t);
	}
}
