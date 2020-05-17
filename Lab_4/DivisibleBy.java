public class DivisibleBy implements BooleanCondition<Integer> {
    private Integer i;

    public DivisibleBy(Integer i) {
        this.i = i;
    }

    /**
    Test method takes in integer x and
    checks if box object is divisible by x.
    */
    public boolean test(Integer x) {
        if (x % i == 0) {
            return true;
        } else {
            return false;
        }
    }
}
    
