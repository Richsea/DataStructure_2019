public interface List {
    void delete(Object x);
    Boolean addFirst(Object x);
    Boolean addLast(Object x);
    void deleteLast();
    int size();
    void printList();
    void clear();
    Object getData(int x);
}
