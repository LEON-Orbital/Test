class LastDigitsOfHashCode implements Transformer<Object, Integer> {
    private Integer i;

    public LastDigitsOfHashCode(Integer i) {
        this.i = i;
    }

    public Integer transform(Object t) {
        Integer a = t.hashCode();
        String b = Integer.toString(a);
        String last = b.substring(b.length() - i);
        Integer res = (Integer) Integer.parseInt(last);
        return res;
    }
}
