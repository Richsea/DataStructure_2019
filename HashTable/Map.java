public interface Map {
    Object get(Object key);
    Object put(Object key, Object value);
    Object remove(Object key);
    int size();
}
