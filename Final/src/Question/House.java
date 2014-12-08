package Question;

public class House {
	
	public double HouseValue(double Income, double Debt, double Years, double AnnualRate){
		
		double Payment = (Income/12) * .18;
		
		double Payment1 = ((Income/12) * .36) - Debt;
		
		double Payments = Math.min(Payment, Payment1);
		
	
		
		double Rate = (1 + AnnualRate);
		
		double Interest = Math.pow(Rate, -Years*12);
		
		double Pay = ((1- Interest)/AnnualRate);
		
		double PV = Payments * Pay;
		
		return PV;
		
	}
	
}
	