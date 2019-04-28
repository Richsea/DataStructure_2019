import java.util.*;

public class CloseAddressingHashTable implements Map {
    private final int INITIAL_SIZE = 10;        // 초기 hashMap 크기
    private Entry[] entries = new Entry[INITIAL_SIZE];
    private boolean needRehash = false;

    CloseAddressingHashTable()
    {
        for(int i = 0; i < entries.length; i++)
        {
            entries[i] = new Entry(null, null, null);
        }
    }

    @Override
    public int size()
    {
        int size = 0;

        Entry entry;
        for(int i = 0; i < entries.length; i++)
        {
            entry = entries[i];

            if(entry.next == null)   continue;

            while(entry.next != null)
            {
                size ++;
                entry = entry.next;
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {  return this.size() == 0;    }

    @Override
    public boolean containsKey(Object key) {
        int hashNum = hash(key);

        Entry entry = entries[hashNum];

        while(entry.next != null)
        {
            if(entry.next.key.equals(key))
                return true;
            entry = entry.next;
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Set<Map.Entry> set = this.entrySet();
        Map.Entry entry;

        for(Iterator iterator = set.iterator(); iterator.hasNext();) {
            entry = (Map.Entry) iterator.next();

            if(entry.getValue().equals(value))
                return true;
        }
        return false;
    }

    @Override
    public Object get(Object key)
    {
        int hashNum = hash(key);

        Entry entry = entries[hashNum];

        while(entry.next != null)
        {
            if(entry.next.key.equals(key))
                return entry.next.value;

            entry = entry.next;
        }

        return null;
    }

    @Override
    public Object put(Object key, Object value)
    {
        if(needRehash) rehash();

        int hashNum = hash(key);

        Entry entry = entries[hashNum];
        int countLength = 0;

        while(entry.next != null)
        {
            if(entry.next.key.equals(key))
            {
                Object oldValue = entry.next.value;
                entry.next.value = value;
                return oldValue;
            }
            entry = entry.next;
            countLength++;
        }

        Entry newEntry = new Entry(key, value, null);
        entry.next = newEntry;

        if(entries.length < countLength)
            needRehash = true;

        return newEntry.value;
    }

    @Override
    public Object remove(Object key)
    {
        int hashNum = hash(key);

        Entry entry = entries[hashNum];

        while(entry.next != null)
        {
            if(entry.next.key.equals(key))
            {
                Object oldValue = entry.next.value;
                entry.next = entry.next.next;

                return oldValue;
            }
            entry = entry.next;
        }

        return null;
    }

    @Override
    public void putAll(Map m) {
        int mapSize = m.size();

        if(mapSize == 0) throw new NullPointerException();

        Map.Entry entry;

        for(Iterator iterator = m.entrySet().iterator(); iterator.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (Map.Entry)iterator.next();
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear()
    {
        entries = new Entry[INITIAL_SIZE];
        for(int i = 0; i < entries.length; i++)
        {
            entries[i] = new Entry(null, null, null);
        }
    }

    @Override
    public Set keySet() {
        Set set = new HashSet();
        Entry entry;

        for(int i = 0; i < this.entries.length; i++)
        {
            entry = entries[i];

            while(entry.next != null)
            {
                set.add(entry.next.key);
                entry = entry.next;
            }
        }
        return set;
    }

    @Override
    public Collection values() {
        Collection collection = new HashSet<>();
        Entry entry;

        for(int i = 0; i < this.entries.length; i++)
        {
            entry = entries[i];
            while(entry.next != null)
            {
                collection.add(entry.next.value);
                entry = entry.next;
            }
        }

        if(collection.isEmpty())    return null;

        return collection;
    }

    @Override
    public Set<Map.Entry> entrySet()
    {
        Set<Map.Entry> set = new HashSet<>();
        Entry entry;

        for(int i = 0; i < this.entries.length; i++)
        {
            entry = entries[i];

            while(entry.next != null)
            {
                set.add(Map.entry(entry.next.key, entry.next.value));
                entry = entry.next;
            }
        }

        if(set.isEmpty()) return null;

        return set;
    }

    private int hash(Object key)
    {
        if(key == null) throw new IllegalArgumentException();   // key 자체가 잘못들어온 경우 예외처리
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    private void rehash()
    {
        Set<Map.Entry> set = this.entrySet();
        entries = new Entry[2*entries.length];
        needRehash = false;

        for(int i = 0; i < entries.length; i++)
        {
            entries[i] = new Entry(null, null, null);
        }

        Map.Entry entry;
        for(Iterator iterator = set.iterator(); iterator.hasNext();) {
            entry = (Map.Entry) iterator.next();
            this.put(entry.getKey(), entry.getValue());
        }

    }

    private class Entry
    {
        Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
