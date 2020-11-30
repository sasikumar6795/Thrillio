package com.wipro.HMS;

public class BlueCrossShield implements InsuranceBrand {

	@Override
	public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
		// TODO Auto-generated method stub

		if (age > 55 && smoking == true) {
			if (insurancePlan instanceof PlatinumPlan) {
				return 200 + 100;
			} else if (insurancePlan instanceof GoldPlan) {
				return 150 + 90;
			} else if (insurancePlan instanceof SilverPlan) {
				return 100 + 80;
			} else if (insurancePlan instanceof BronzePlan) {
				return 50 + 70;
			}
		} else if (age < 55 && smoking == true) {
			if (insurancePlan instanceof PlatinumPlan) {
				return 100;
			} else if (insurancePlan instanceof GoldPlan) {
				return 90;
			} else if (insurancePlan instanceof SilverPlan) {
				return 80;
			} else if (insurancePlan instanceof BronzePlan) {
				return 70;
			}
		} else if (age > 55 && smoking == false) {
			if (insurancePlan instanceof PlatinumPlan) {
				return 200;
			} else if (insurancePlan instanceof GoldPlan) {
				return 150;
			} else if (insurancePlan instanceof SilverPlan) {
				return 100;
			} else if (insurancePlan instanceof BronzePlan) {
				return 50;
			}
		}

		return 0;

	}

}
