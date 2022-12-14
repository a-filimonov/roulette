package com.roulette.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.roulette.stats.UserStats;

public class SortedMultiMap<K, V extends UserStats> {

    private final Map<K, SortedSet<V>> map = new HashMap<>();

    /**
     * Add the specified value with the specified key in this multimap.
     */
    public void add(K key, V value) {
        map.computeIfAbsent(key, k -> new TreeSet<>());

        map.get(key).add(value);
    }

    /**
     * Associate the specified key with the given value if not
     * already associated with a value
     */
    public void addIfAbsent(K key, V value) {
        map.computeIfAbsent(key, k -> new TreeSet<>());
        map.get(key).add(value);
    }

    /**
     * Returns the Collection of values to which the specified key is mapped,
     * or null if this multimap contains no mapping for the key.
     */
    public SortedSet<V> get(Object key) {
        return map.get(key);
    }

    /**
     * Returns a set view of the keys contained in this multimap.
     */
    public Set<K> keySet() {
        return map.keySet();
    }

    /**
     * Returns a set view of the mappings contained in this multimap.
     */
    public Set<Map.Entry<K, SortedSet<V>>> entrySet() {
        return map.entrySet();
    }

    /**
     * Returns a Collection view of Collection of the values present in
     * this multimap.
     */
    public Collection<SortedSet<V>> values() {
        return map.values();
    }

    /**
     * Returns true if this multimap contains a mapping for the specified key.
     */
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    /**
     * Removes the mapping for the specified key from this multimap if present
     * and returns the Collection of previous values associated with key, or
     * null if there was no mapping for key.
     */
    public Collection<V> remove(Object key) {
        return map.remove(key);
    }

    /**
     * Returns the total number of key-value mappings in this multimap.
     */
    public int size() {
        int size = 0;
        for (Collection<V> value : map.values()) {
            size += value.size();
        }
        return size;
    }

    /**
     * Returns true if this multimap contains no key-value mappings.
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * Removes all the mappings from this multimap.
     */
    public void clear() {
        map.clear();
    }

    /**
     * Removes the entry for the specified key only if it is currently
     * mapped to the specified value and return true if removed
     */
    public boolean remove(K key, V value) {
        if (map.get(key) != null) // key exists
            return map.get(key).remove(value);

        return false;
    }

    /**
     * Replaces the entry for the specified key only if currently
     * mapped to the specified value and return true if replaced
     */
    public boolean replace(K key, V oldValue, V newValue) {
        if (map.get(key) != null) {
            if (map.get(key).remove(oldValue)) {
                return map.get(key).add(newValue);
            }
        }
        return false;
    }
}
