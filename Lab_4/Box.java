public class Box<T> {
    protected T t;
    private static final Box<?> EMPTY_BOX = new Box<>(null); 

    protected Box(T t) {
        this.t = t;
    }
    
    /**
    Static method of to put a object of type T in a box.
    */
    public static <T> Box<T> of(T t) {
        if (t == null) {
            return null;
        } else {
            return new Box<T>(t);
        }
    }

    @Override
    public String toString() {
        if (this.t == null) {
            return "[]";
        } else {
            return "[" + this.t + "]";
        }
    }

    /**
    Box equals method to compare this box with other objects.
    */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        } else if (!(object instanceof Box)) {
            return false;
        } else if (this.t == null) {
            return this.t == ((Box) object).t;
        } else {
            return this.t.equals(((Box) object).t);
        }
    }

    /**
    Static method ofNullable to enable empty box to be created. 
    */
    public static <T> Box<T> ofNullable(T object) {
        if (object == null) {
            return Box.empty();
        } else {
            return new Box<T>(object);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> Box<T> empty() {
        Box<T> emptyBox = (Box<T>) EMPTY_BOX;
        return emptyBox;
    }

    /**
    Method to check if there if a box contains anything.
    */
    public boolean isPresent() {
        if (this.t == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
    Filter method that takes in BoolCond as parameter.
    */
    public Box<T> filter(BooleanCondition<? super T> condition) {
        if (this.t == null) {
            return Box.empty();
        } else if (condition.test(this.t) == true) {
            return this;
        } else {
            return Box.empty();
        }
    }

    /**
    Map method that takes in Transformer as parameter.
    */
    public <U> Box<U> map(Transformer<? super T,? extends U> thing) {
        if (this.t == null) {
            return Box.empty();
        } else { 
            return (Box<U>) Box.ofNullable(thing.transform(this.t));
        }
    }    

}
