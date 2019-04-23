public class HashTable implements Map
{
    int size = 10;
    private Entry[] entries = new Entry[size];
    private final Entry NIL = new Entry(null, null);

    @Override
    public Object get(Object key) {


        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    private int hash(Object key)
    {
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
