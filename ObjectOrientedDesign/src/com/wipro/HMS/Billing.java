package com.wipro.HMS;

public class Billing {

	public static void main(String[] args) {
		
		/*HealthInsurancePlan healthInsurancePlan = new SilverPlan();
		System.out.println(healthInsurancePlan.getCoverage());
		Patient patient = new Patient();
		patient.setInsurancePlan(healthInsurancePlan);
		//double[] payments = Billing.computePaymentAmount(patient, 950);
		//System.out.println(payments[0]);
*/		User staff = new User();
		InsuranceBrand insuranceBrand = new BlueCrossShield();
		HealthInsurancePlan healthInsurancePlan = new PlatinumPlan();
		
		healthInsurancePlan.setOfferedBy(insuranceBrand);
		staff.setInsurancePlan(healthInsurancePlan);
		double computeMonthlyPremium = healthInsurancePlan.computeMonthlyPremium(8000,56,false);
		System.out.println(computeMonthlyPremium);
		
		
		
		

	}
	 /*public static double[] computePaymentAmount(Patient patient, double amount) {
	        double[] payments = new double[2];
	        
	         HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
	       
	        double paymentByInsurance = 0.0;
			
			if (patientInsurancePlan != null) {					
				paymentByInsurance = amount * patientInsurancePlan.getCoverage();
				payments[0] = paymentByInsurance;
			}
				
			if (patientInsurancePlan instanceof PlatinumPlan) {
				payments[1] = amount - paymentByInsurance - 50;
			} else if (patientInsurancePlan instanceof GoldPlan) {
				payments[1] = amount - paymentByInsurance - 40;
			} else if (patientInsurancePlan instanceof SilverPlan) {
				payments[1] = amount - paymentByInsurance - 30;
			} else if (patientInsurancePlan instanceof BronzePlan) {
				payments[1] = amount - paymentByInsurance - 25;
			} else {
				payments[1] = amount - 20;
			}		
			
	        	
	        return payments;
	    }*/


}
