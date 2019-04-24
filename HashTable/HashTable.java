public class HashTable implements Map
{
    private int size = 10;
    private Entry[] entries = new Entry[size];
    private final Entry NIL = new Entry(null, null);

    @Override
    public Object get(Object key) {
        int hashNum = hash(key);

        while(entries[hashNum] != null)
        {
            Entry entry = entries[hashNum];

            if(entry.key .equals(key))
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
        //75%이상 채우면 rehashing 실행
        int hashNum = hash(key);

        while(entries[hashNum] != null)
        {
            Entry entry = entries[hashNum];

            if(entry == NIL)
            {

            }

            hashNum ++;

            if(hashNum >= entries.length)
            {
                hashNum = 0;
            }
        }

        return null;
    }

    @Override
    public Object remove(Object key)
    {
        int hashNum = hash(key);

        while(entries[hashNum] != null)
        {
            Entry entry = entries[hashNum];

            if(entry.key.equals(key))
            {
                Object oldValue = entry.value;

                entries[hashNum] = NIL;
                size--;
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
    public int size() {
        return size;
    }

    private int hash(Object key)
    {
        if(key == null) throw new IllegalArgumentException();   // key 자체가 잘못들어온 경우 예외처리
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    private void rehash()
    {

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
