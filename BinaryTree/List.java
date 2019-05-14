public interface List<T> {
    void insert(T x);
    void delete(T x);
    T get(int x);
    Boolean addLast(T x);
    void deleteLast();
    int size();
    void printList();
    void clear();
}
