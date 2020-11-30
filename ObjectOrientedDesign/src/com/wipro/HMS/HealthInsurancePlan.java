package com.wipro.HMS;

public abstract class HealthInsurancePlan {

	// Code for 'coverage' field goes here
	protected double coverage;
	private InsuranceBrand offeredBy;
    
    public InsuranceBrand getOfferedBy()
    {
        return offeredBy;
    }
    public void setOfferedBy(InsuranceBrand offeredBy)
    {
        this.offeredBy = offeredBy;
    }

	// Don't worry about the below code and also the InsuranceBrand class
	public double getCoverage() {
		return coverage;
	}

	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}
	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
