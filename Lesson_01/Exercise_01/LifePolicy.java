package Lesson_01.Exercise_01;

public class LifePolicy extends InsurancePolicy {

    public LifePolicy(String policyId, double sumInsured) {
        super(policyId, sumInsured);
    }

    @Override
    public double annualPremium() {
        return sumInsured * 0.012;
    }

    @Override
    public String coverageType() {
        return "Life Insurance";
    }
}
