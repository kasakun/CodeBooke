import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

/**
 * 
 * @author Zeyu Chen
 * @version 0.1
 */

public class HashMap<K, V> implements HashMapInterface<K, V>{
    // Map entry
    private MapEntry<K, V>[] table;
    private int size;

    /**
     * Constructor with no setting
     */
    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    /**
     * constructor with initial size
     * 
     * @param initial size
     */
    public HashMap(int initialCapacity) {
        table = new MapEntry[initialCapacity];
        size = 0;
    }

    /**
     * @see put interface
     * Point: return old value if key is the same.
     */
    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Input key or value is null!");
        }

        // resize if larger than the load factor
        if ((double)(size + 1)/table.length > MAX_LOAD_FACTOR) {
            resizeBackingTable(2*table.length + 1);
        }

        // hashCode return int.
        int index = Math.abs(key.hashCode() % table.length);

        if (table[index] == null) {
            table[index] = new MapEntry<K,V>(key, value);
            ++size;
        } else {
            /**
             * The idea is first split into 2 situations:
             * a. current index is null, clean which mean ca be used directly
             * b. current is not null, maybe used, may be not.
             * 
             * for b, check the removed status to determine whether it is removed.
             * if removed, use it.
             * if not, check if it has same key, if it is, replace it.
             */
            int count = 0;
            int nextIndex = -1;

            // situation b
            while (table[index] != null && count != table.length) {
                // find the nearest available slot
                if (table[index].isRemoved() && nextIndex == -1) {
                    nextIndex = index;
                }

                // the situation meet the same key
                if (!table[index].isRemoved() && table[index].getKey().equals(key)) {
                    V oldValue = table[index].getValue();
                    table[index].setValue(value);
                    return oldValue;
                }

                // Mod
                ++count;
                index = ((index + 1) == table.length) ? 0 : (index + 1);
            }

            // execute for situation a, may be we dont need == null here
            if (table[index] == null && nextIndex == -1) {
                table[index] = new MapEntry<>(key, value);
            } else {
                table[nextIndex] = new MapEntry<>(key, value);
            }
            ++size;
        }

        return null; // not the same key
    }

    /**
     * 
     * @see interface
     */
    @Override
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Input key is null.");
        }

        int index = Math.abs(key.hashCode()%table.length);

        if (table[index] == null) {
            throw new NoSuchElementException("Hash Map does not contain this pair.");    
        } else {
            int count = 0;
            while (table[index] != null && count != table.length) {

                if (!table[index].isRemoved() && table[index].getKey().equals(key)) {
                    table[index].setRemoved(true);
                    --size;
                    return table[index].getValue();
                }

                ++count;
                index = ((index + 1) == table.length) ? 0 : (index + 1);
            }
        }
        throw new NoSuchElementException("Hash Map does not contain this pair.");
    }

    /**
     * give a key find a not null and not removed slot. 
     * @see Interface
     */
    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Input key is null.");
        }

        int index = Math.abs(key.hashCode() % table.length);
        int count = 0;

        while (table[index] != null && count != table.length) {
            if (!table[index].isRemoved() && table[index].getKey().equals(key)) {
                return table[index].getValue();
            }

            ++count;
            index = ((index + 1) == table.length) ? 0 : (index + 1);
        }

        throw new NoSuchElementException("Hash Map does not contain this pair.");
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Input key is null.");
        }

        int index = Math.abs(key.hashCode() % table.length);
        int count = 0;

        if (table[index] == null) {
            return false;
        } else {    
            while (table[index] != null && count != table.length) {
                if (!table[index].isRemoved() && table[index].getKey().equals(key)) {
                    return true;
                }

                ++count;
                index = ((index + 1) == table.length) ? 0 : (index + 1);
            }
        }

        return false;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public void clear() {
        table = new MapEntry[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * 
     * @return size of the table
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();

        for (MapEntry<K, V> entry : table) {
            if (entry != null && !entry.isRemoved()) {
                keys.add(entry.getKey());
            }
        }

        return keys;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public List<V> values() {
        List<V> values = new ArrayList<>();

        for (MapEntry<K, V> entry : table) {
            if (entry != null && !entry.isRemoved()) {
                values.add(entry.getValue());
            }
        }

        return values;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public void resizeBackingTable(int length) {

        if (length <= 0 || length < size) {
            throw new IllegalArgumentException("Invalid length.");
        }

        MapEntry<K, V>[] newTable = new MapEntry[length];

        // relocate all entry with new hash structure.
        for (MapEntry<K, V> entry : table) {
            if (entry != null && !entry.isRemoved()) {
                int newIndex = Math.abs(entry.getKey().hashCode()%newTable.length);

                if (newTable[newIndex] == null) {
                    newTable[newIndex] = entry;
                } else {
                    while (newTable[newIndex] != null) {
                        newIndex = (newIndex + 1 == newTable.length)? 0 : newIndex + 1;
                    }
                    newTable[newIndex] = entry;
                }
            }
        }

        table = newTable;
    }

    /**
     * @return table
     */
    @Override
    public MapEntry<K, V>[] getTable() {
        return table;
    }
}