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
        if(entries.length * 0.75 < size)   rehash();

        int hashNum = hash(key);
        int firstNIL = -1;      // 첫번째 NIL이 발견된 위치 저장

        while(entries[hashNum] != null)
        {
            Entry entry = entries[hashNum];

            if(entry == NIL && firstNIL == -1)  // 탐색 도중 NIL 데이터가 발견되었지만, 나중에 같은 key를 가진 데이터가 없을때를 대비.
            {
                firstNIL = hashNum;
                break;
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
        size++;

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
    public int size()
    {
        return size;
    }

    private int hash(Object key)
    {
        if(key == null) throw new IllegalArgumentException();   // key 자체가 잘못들어온 경우 예외처리
        return (key.hashCode() & 0x7FFFFFFF) % entries.length;
    }

    private void rehash()
    {
        Entry[] oldEntry = entries;
        entries = new Entry[2*oldEntry.length];

        for(int i = 0; i < oldEntry.length; i++)
        {
            Entry entry = oldEntry[i];

            if(entry == null || entry == NIL) continue;
            //int newHashNum = this.hash(oldEntry[i]);

            this.put(entry.key, entry.value);
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
