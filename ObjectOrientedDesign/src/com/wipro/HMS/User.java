package com.wipro.HMS;

public class User
{
    private int age;
    private boolean smoking;
    private boolean insured;
    private HealthInsurancePlan insurancePlan;
    
    public void setAge(int age)
    {
        this.age=age;
    }
    public int getAge()
    {
        return age;
    }
    public void setSmoking(boolean smoking)
    {
        this.smoking=smoking;
    }
    public boolean isSmoking()
    {
        return smoking;
    }
    public boolean isinsured()
    {
        return insured;
    }
    public void setInsured(boolean insured)
    {
        this.insured=insured;
    }
    
    public HealthInsurancePlan getInsurancePlan()
    {
        return insurancePlan;
    }
    public void setInsurancePlan(HealthInsurancePlan insurancePlan)
    {
        this.insurancePlan=insurancePlan;
    }
}
