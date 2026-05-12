import Exercise_03.SavingsAccount;

void main() {
    System.out.println("Multiple Interface Implementation");

    SavingsAccount savingsAccount = new SavingsAccount();
    savingsAccount.setInterestRate(.20);
    System.out.println(savingsAccount.getInterestRate());
    System.out.println(savingsAccount.canArchive());
}
