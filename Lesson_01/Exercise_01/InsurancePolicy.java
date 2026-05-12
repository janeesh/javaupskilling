package Lesson_01.Exercise_01;

public abstract class InsurancePolicy {

    protected String policyId;
    protected double sumInsured;

    public InsurancePolicy(String policyId, double sumInsured) {
        super();
        this.policyId = policyId;
        this.sumInsured = sumInsured;
    }
    public abstract double annualPremium();
    public abstract String coverageType();

    public double totalPremium(int years) {
        return annualPremium() * years;
    }

    public final void printSummary() {
        System.out.println("Policy ID: " + policyId);
        System.out.println("Coverage Type: " + coverageType());
        System.out.println("Sum Insured: " + sumInsured);
        System.out.println("Annual Premium: " + annualPremium());
        System.out.println("Total Premium 5 years " + totalPremium(5));
    }
}