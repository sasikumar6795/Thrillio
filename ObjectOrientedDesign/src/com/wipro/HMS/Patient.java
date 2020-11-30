package com.wipro.HMS;

public class Patient {
	private HealthInsurancePlan insurancePlan;
	private boolean insured;
	   
	   public HealthInsurancePlan getInsurancePlan()
	   {
	       return insurancePlan;
	   }
	   public void setInsurancePlan(HealthInsurancePlan insurancePlan)
	   {
	       this.insurancePlan =insurancePlan;
	   }
	   
	   public boolean isInsured()
	   {
	       return insured;
	   }
	   public void setInsured(boolean insured)
	   {
	       this.insured = insured;
	   }
}
