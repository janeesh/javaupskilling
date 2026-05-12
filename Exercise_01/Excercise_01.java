import Exercise_01.InsurancePolicy;
import Exercise_01.LifePolicy;
import Exercise_01.VehiclePolicy;

void main() {
    System.out.println("Insurance Policy Hierarchy");
    InsurancePolicy[] policies = new InsurancePolicy[]{
            new LifePolicy("LP-001", 50000),
            new VehiclePolicy("VP-001", 18000)
    };

    for (InsurancePolicy policy : policies) {
        policy.printSummary();
        System.out.println("\n");
    }
}
