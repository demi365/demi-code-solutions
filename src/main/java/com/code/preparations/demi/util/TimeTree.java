package com.code.preparations.demi.util;

import java.util.Optional;
import java.util.TreeMap;
import java.util.Map;

public class TimeTree {

    private int maxSize;
    private TreeMap<ValueTree, ValueTree> vals;

    public TimeTree(int maxSize) {
        this.maxSize = maxSize;
        vals = new TreeMap<>((a,b) -> a.equals(b) ? 0 : Long.compare(a.millis, b.millis));
    }

    public void put(String key, String value, long timeToLeaveInMilliseconds) {
        System.out.println("Started put:: "+key+" for value "+value);
        this.cleanUp();
        if(timeToLeaveInMilliseconds <0) {
            return;
        }

        Map.Entry<ValueTree, ValueTree> firstEntry = vals.firstEntry();
        if(vals.isEmpty() || timeToLeaveInMilliseconds >= firstEntry.getKey().millis) {
            if(vals.size() == maxSize && vals.get(new ValueTree(key, 0L)) == null) {
                System.out.println("Removing first element "+firstEntry.getKey());
                vals.remove(firstEntry.getKey());
            }
            vals.put(new ValueTree(key, timeToLeaveInMilliseconds), new ValueTree(value, timeToLeaveInMilliseconds));
            System.out.println("SIZE of vals "+vals.size());
        }
    }

    public Optional<String> get(String key) {
        System.out.println("Started get:: "+key);
        this.cleanUp();
        ValueTree value = vals.get(new ValueTree(key, 0L));
        if(value != null && value.millis <= System.currentTimeMillis()) {
            vals.remove(new ValueTree(key, 0L));
            return Optional.empty();
        }
        return Optional.ofNullable(value).map(v -> v.key);
    }

    public int size() {
        this.cleanUp();
        return vals.size();
    }

    public void cleanUp() {
        while(!vals.isEmpty() && vals.firstEntry().getKey().millis < System.currentTimeMillis()) {
            System.out.println("Cleaning up "+vals.firstEntry().getKey()+" with value "+vals.firstEntry().getValue());
            vals.remove(vals.firstEntry().getKey());
        }
    }

    public static class ValueTree {

        public String key;
        public long millis;

        public ValueTree(String key, long millis) {
            this.key = key;
            this.millis = millis;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if(o instanceof ValueTree){
                ValueTree that = (ValueTree) o;
                return this.key.equals(that.key);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.key.hashCode();
        }

        @Override
        public String toString() {
            return this.key;
        }

    }

}
