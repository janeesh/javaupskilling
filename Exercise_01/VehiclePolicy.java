package Exercise_01;

public class VehiclePolicy extends InsurancePolicy {

    public VehiclePolicy(String policyId, double sumInsured) {
        super(policyId, sumInsured);
    }

    @Override
    public double annualPremium() {
        return (sumInsured * 0.03) + 50.0;
    }

    @Override
    public String coverageType() {
        return "Vehicle Insurance";
    }
}
