public class LongerThan implements BooleanCondition<String> {
    private Integer i;

    public LongerThan(Integer i) {
        this.i = i;
    }

    public boolean test(String x) {
        return x.length() > i;
    }
}
