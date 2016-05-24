package rocketServer;

import java.io.IOException;

import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			LoanRequest lq = (LoanRequest) message;
			
			//	TODO - RocketHub.messageReceived

			//	You will have to:
			//	Determine the rate with the given credit score (call RateBLL.getRate)
			//		If exception, show error message, stop processing
			//		If no exception, continue
			//	Determine if payment, call RateBLL.getPayment
			//	
			//	you should update lq, and then send lq back to the caller(s)
			
			double rate = RateBLL.getRate(lq.getiCreditScore());
			double payment = RateBLL.getPayment(rate, 12, lq.getiDownPayment(), lq.getiDownPayment(), false);//find arguments for getPayment
			lq.setdRate(rate);
			lq.setdPayment(payment);
			if (payment < lq.getIncome()*(.28) & payment < lq.getIncome()*(.36)-lq.getExpenses()){
				
			}
			else{
				lq.setReults("House Cost Too High");
			}
			
			sendToAll(lq);
		}
	}
}
