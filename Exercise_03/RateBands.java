package Exercise_03;

public interface RateBands {
    double MIN_RATE = 0.001;
    double MAX_RATE = 0.25;

    static boolean isValidRate(double rate) {
        return rate >= MIN_RATE && rate <= MAX_RATE;
    }
}
