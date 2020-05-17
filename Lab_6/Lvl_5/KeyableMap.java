import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class KeyableMap<T,K,V extends Keyable<K>> implements Keyable<T> {
    protected final T key;
    protected Map<K,V> map;

    public KeyableMap(T key) {
        this.key = key;
        this.map = new HashMap<>();
    }

    /**
     * Method to get the value of a given key
     * in KeyableMap.
     */
    public Optional<V> get(K key) {
            return Optional.ofNullable(this.map.get(key));
    }

    public T getKey() {
        return this.key;
    }

    public KeyableMap<T,K,V> put(V item) {
        map.put(item.getKey(), item);
        return this;
    }
    
    @Override
    public String toString() {
        if (map.isEmpty()) {
            return this.key + ": {}";
        }
        return (this.key + ": " + map.values())
                    .replace("[","{").replace("]","}");
    }


}





