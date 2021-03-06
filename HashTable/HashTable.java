import java.util.*;

public class HashTable implements Map
{
    private final int INITIAL_SIZE = 10;        // 초기 hashMap 크기
    private Entry[] entries = new Entry[INITIAL_SIZE];
    private final Entry NIL = new Entry(null, null);

    @Override
    public int size()
    {
        int size = 0;
        Entry entry;

        for(int i = 0; i < entries.length; i++)
        {
            entry = entries[i];
            if(entry != null && entry != NIL)
                size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return this.size() == 0;
    }

    @Override
    public boolean containsKey(Object key)
    {
        int hashNum = hash(key);
        Entry entry;

        while(entries[hashNum] != null)
        {
            entry = entries[hashNum];

            if(entry != NIL && entry.key.equals(key))
                return true;

            hashNum++;
            if(hashNum >= entries.length)
            {
                hashNum = 0;
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value)
    {

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
        Entry entry;

        while(entries[hashNum] != null)
        {
            entry = entries[hashNum];

            if(entry != NIL && entry.key.equals(key))
            {
                return entry.value;
            }

            hashNum++;
            if(hashNum >= entries.length)
            {
                hashNum = 0;
            }
        }

        return null;
    }

    @Override
    public Object put(Object key, Object value)
    {
        if(entries.length * 0.7 < this.size())   rehash();

        int hashNum = hash(key);
        int firstNIL = -1;      // 첫번째 NIL이 발견된 위치 저장
        Entry entry;

        while(entries[hashNum] != null)
        {
            entry = entries[hashNum];

            if(entry == NIL && firstNIL == -1)  // 탐색 도중 NIL 데이터가 발견되었지만, 나중에 같은 key를 가진 데이터가 없을때를 대비.
            {
                firstNIL = hashNum;
                hashNum++;
                continue;
            }

            if(entry.key.equals(key))   // 같은 key를 가진 데이터가 존재하는지 확인
            {
                Object oldValue = entry.value;
                entries[hashNum].value = value;
                return oldValue;
            }

            hashNum ++;

            if(hashNum >= entries.length)
            {
                hashNum = 0;
            }
        }

        if(firstNIL == -1)
        {
            entries[hashNum] = new Entry(key, value);
        }
        else
        {
            entries[firstNIL] = new Entry(key, value);
        }

        return entries[hashNum];
    }

    @Override
    public Object remove(Object key)
    {
        int hashNum = hash(key);
        Entry entry;

        while(entries[hashNum] != null)
        {
            entry = entries[hashNum];

            if(entry != NIL && entry.key.equals(key))
            {
                Object oldValue = entry.value;

                entries[hashNum] = NIL;
                return oldValue;
            }

            hashNum++;

            if(hashNum >= entries.length)
            {
                hashNum = 0;
            }
        }

        return null;
    }

    @Override
    public void putAll(Map m)
    {
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
    public void clear() {   entries = new Entry[INITIAL_SIZE];  }

    @Override
    public Set keySet()
    {
        Set set = new HashSet();
        Entry entry;

        for(int i = 0; i < this.entries.length; i++)
        {
            entry = entries[i];
            if(entry != null && entry != NIL)
            {
                set.add(entry.key);
            }
        }
        return set;
    }

    @Override
    public Collection values()
    {
        Collection collection = new HashSet<>();
        Entry entry;

        for(int i = 0; i < this.entries.length; i++)
        {
            entry = entries[i];
            if(entry != null && entry != NIL)
            {
                collection.add(entry.value);
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
            if(entry != null && entry != NIL)
            {
                set.add(Map.entry(entry.key, entry.value));
            }
        }

        if(set.isEmpty())   return null;

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

        Entry(Object key, Object value)
        {
            this.key = key;
            this.value = value;
        }
    }
}
