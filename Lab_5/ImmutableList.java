import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.Comparator;


public class ImmutableList<T> {
    private final List<T> list;

    /**
     * Constructor to create ImmutableList by taking in a generic list.
     */
    public ImmutableList(List<T> list) {
        List<T> copy = new ArrayList<>();
        for (T t : list) {
            copy.add(t);
        }
        this.list = copy;
    }

    /**
     * Constructor to create ImmutableList by taking in 
     * sequence of items as variable length arguments.
     */
    @SafeVarargs
    public ImmutableList(T... t) {
        List<T> actual = new ArrayList<T>(Arrays.asList(t));
        List<T> copy = new ArrayList<>();
        for (T element : actual) {
            copy.add(element);
        }
        this.list = copy;
    }

    /**
     * Method to remove first instance of particular item in ImmutableList. 
     */
    public ImmutableList<T> remove(T t) {
        ArrayList<T> hold = new ArrayList<>();
        int counter = 0;
        for (T x : this.list) {
            if (counter == 1) {
                hold.add(x);
            } else if (t.equals(x)) {
                counter += 1;
                continue;
            } else {
                hold.add(x);
            }
        }    
        return new ImmutableList<T>(hold);
    }

    /**
     * Method to add item to ImmutableList.
     */
    public ImmutableList<T> add(T t) {
        ArrayList<T> hold = new ArrayList<>();
        for (T x : this.list) {
            hold.add(x);
        }
        hold.add(t);

        return new ImmutableList<T>(hold);
    }

    /**
     * Method to replace all instances of item i with new item j.
     */
    public ImmutableList<T> replace(T i, T j) {
        ArrayList<T> hold = new ArrayList<>();
        for (T x : this.list) {
            if (x.equals(i)) {
                hold.add(j);
            } else {
                hold.add(x);
            }
        }
        return new ImmutableList<T>(hold);
    }

    /**
     * Method to return an ImmutableList with elements 
     * based on a Predicate argument.
     */
    public ImmutableList<T> filter(Predicate<? super T> pred) {
        List<T> newList = new ArrayList<>();
        for (T item : list) {
            if (pred.test(item)) {
                newList.add(item);
            } else {
                continue;
            }
        }
        return new ImmutableList<T>(newList);
    }


    /**
     * Method to return an ImmutableList in which 
     * all elements are transformed based on a Function argument.
     */
    public <U> ImmutableList<U> map(Function<? super T, ? extends U> func) {
        List<U> newList = new ArrayList<>();
        for (T item : list) {
            newList.add(func.apply(item));
        }
        return new ImmutableList<U>(newList);
    }
            
    /**
     * Method to return an ImmutableList truncated to the length 
     * specified by given value.
     */
    public ImmutableList<T> limit(long value) { 

        if (value < 0) {
            throw new IllegalArgumentException("limit size < 0");
        }

        List<T> newList = new ArrayList<>();
        int counter = 0;
        for (T item : list) {
            if (counter == value) {
                break;
            } else { 
                newList.add(item);
                counter += 1;
            }
        }
        return new ImmutableList<T>(newList);
    }

    /**
     * Method to sort ImmutableList using natural
     * order of items in the ImmutableList.
     */
    public ImmutableList<T> sorted() {
        if (this.list.size() == 0) {
            return new ImmutableList<T>(this.list);
        } else if (!(this.list.get(0) instanceof Comparable)) {
            throw new IllegalStateException(
                    "List elements do not implement Comparable");
        } else {
            List<T> newList = new ArrayList<>();
            for (T item : list) {
                newList.add(item);
            }
            @SuppressWarnings("unchecked")
            Comparator<T> comp = (t1, t2) -> ((Comparable<T>) t1).compareTo(t2);
            newList.sort(comp);
            return new ImmutableList<T>(newList); 
        }
    }

    /**
     * Method to sort ImmutableList using a given Comparator argument.
     */
    public ImmutableList<T> sorted(Comparator<T> comp) {
        if (comp == null) {
            throw new NullPointerException("Comparator is null");
        }
        List<T> newList = new ArrayList<>();
        for (T item : list) {
            newList.add(item);
        }
        newList.sort(comp);
        return new ImmutableList<T>(newList);
    }

    /**
     * Method to return items in the list as an array of type Object[].
     */
    public Object[] toArray() {
        int arraySize = list.size();
        Object[] newArray = new Object[arraySize];

        for (int i = 0; i < arraySize; i++) {
            newArray[i] = (Object) list.get(i);
        }
        return newArray;
    }

    /**
     * Methods to return items in the list as an array of the same
     * type as the argument.
     */
    public <U> U[] toArray(U[] a) {
        try {

            list.toArray(a);

        } catch (ArrayStoreException ex) {
            throw new ArrayStoreException("Cannot add element to array as it is the wrong type");
        } catch (NullPointerException ex) {
            throw new NullPointerException("Input array cannot be null");
        } 
        return list.toArray(a);
    }

    @Override
    public String toString() {
        return list.toString();
    }


}














