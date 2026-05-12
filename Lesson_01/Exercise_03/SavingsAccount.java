package Lesson_01.Exercise_03;

public class SavingsAccount implements RateBands, Archivable{
    private double rate;
    private boolean archived;
    public void setInterestRate(double r){
        if(RateBands.isValidRate(r)) {
            this.rate = r;
        }else {
            System.out.println("Invalid Rate");
        }
    }
    public double getInterestRate() {
        return rate;
    }

    @Override
    public boolean canArchive() {
        return Archivable.super.canArchive();
    }

    @Override
    public void archive() {
        this.archived=true;
    }
}