import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Клас VegetableSet описує типізовану колекцію класу Vegetable, що реалізує інтерфейс Set.
 * В ньому реалізовані всі методи інтерфейсу Set, та містить у собі три типи конструкторів.
 * 1) VegetableSet() - пустий конструктор (не передаються об'єкти);
 * 2) VegetableSet(Vegetable vegetable) - передається 1 об'єкт типу Vegetable;
 * 3) VegetableSet(Collection<Vegetable> collection) - передається стандартна колекція об'єктів типу Vegetable.
 *
 * @author Dmytro Lutsenko
 */
public class VegetableSet implements Set<Vegetable> {
    /**
     * Клас Node для визначення двозв'язного списку
     */
    private static class Node{
        Vegetable data;
        Node next;
        Node prev;

        Node (Vegetable data){
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * Порожній конструктор VegetableSet.
     */
    public VegetableSet(){
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Конструктор, який приймає один об'єкт класу Vegetable.
     *
     * @param vegetable екземпляр типу Vegetable, який приймається до списку
     */
    public VegetableSet(Vegetable vegetable){
        this();
        add(vegetable);
    }

    /**
     * Конструктор, який приймає стандартну колекцію класу Vegetable.
     *
     * @param collection колекція, елементи якої приймаються до списку
     */
    public VegetableSet(Collection<Vegetable> collection){
        this();
        for (Vegetable vegetable : collection){
            add(vegetable);
        }
    }

    /**
     * Returns the number of elements in this collection. If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return the number of elements in this collection
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this collection contains no elements.
     *
     * @return true if this collection contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this collection contains the specified element.
     * More formally, returns true if and only if this collection contains at least one element e such that Objects.equals(o, e).
     *
     * @param o element whose presence in this set is to be tested
     * @return true if this collection contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Vegetable)) {return false;}

        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this collection. There are no guarantees concerning the order in which
     * the elements are returned (unless this collection is an instance of some class that provides a guarantee).
     *
     * @return an Iterator over the elements in this collection
     */
    @Override
    public Iterator<Vegetable> iterator() {
        return new Iterator<Vegetable>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Vegetable next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Vegetable vegetable = current.data;
                current = current.next;
                return vegetable;
            }
        };
    }

    /**
     * Returns an array containing all othe elements in this collection. If this collection makes any guarantees as to what order its elements are returned by its iterator, this method must return the elements in the same order. The returned array's runtime component type is Object.
     * The returned array will be "safe" in that no references to it are maintained by this collection. (In other words, this method must allocate a new array even if this collection is backed by an array). The caller is thus free to modify the returned array.
     * This method acts as bridge between array-based and collection-based APIs.
     *
     * @return an array, whose runtime component type is Object, containing all the elements in this collection
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        Node current = head;
        while (current != null){
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    /**
     * Returns an array containing all the elements in this collection; the runtime type of the returned array is that of the specified array. If the collection fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this collection.
     * If this collection fits in the specified array with room to spare (i.e., the array has more elements than this collection), the element in the array immediately following the end of the collection is set to null. (This is useful in determining the length of this collection only if the caller knows that this collection does not contain any null elements.)
     * If this collection makes any guarantees as to what order its elements are returned by its iterator, this method must return the elements in the same order.
     *
     * @param a the array into which the elements of this set are to be
     *        stored, if it is big enough; otherwise, a new array of the same
     *        runtime type is allocated for this purpose.
     * @return an array containing all the elements in this collection
     * @param <T> the component type of the array to contain the collection
     */
    @Override
    public <T> T[] toArray(T[] a) {
        Node current = head;
        int i = 0;
        Object[] array = a;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return a;
    }

    /**
     * Ensures that this collection contains the specified element (optional operation). Returns true if this collection changed as a result of the call. (Returns false if this collection does not permit duplicates and already contains the specified element.)
     * Collections that support this operation may place limitations on what elements may be added to this collection. In particular, some collections will refuse to add null elements, and others will impose restrictions on the type of elements that may be added. Collection classes should clearly specify in their documentation any restrictions on what elements may be added.
     * If a collection refuses to add a particular element for any reason other than that it already contains the element, it must throw an exception (rather than returning false). This preserves the invariant that a collection always contains the specified element after this call returns.
     *
     * @param vegetable element whose presence in this collection is to be ensured
     * @return true if this collection changed as a result of the call
     */
    @Override
    public boolean add(Vegetable vegetable) {
        if (contains(vegetable)) {
            return false;
        }

        Node newNode = new Node(vegetable);
        if (head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Removes a single instance of the specified element from this collection, if it is present (optional operation).
     * More formally, removes an element e such that Objects.equals(o, e), if this collection contains one or more such elements.
     * Returns true if this collection contained the specified element (or equivalently, if this collection changed as a result of the call).
     *
     * @param o object to be removed from this set, if present
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Vegetable)) {return false;}

        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns true if this collection contains all the elements in the specified collection.
     *
     * @param c collection to be checked for containment in this set
     * @return true if this collection contains all the elements in the specified collection
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c){
            if (!contains(o)){
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all the elements in the specified collection to this collection (optional operation).
     * The behavior of this operation is undefined if the specified collection is modified while the operation is in progress.
     * (This implies that the behavior of this call is undefined if the specified collection is this collection, and this collection is nonempty.)
     *
     * @param c collection containing elements to be added to this collection
     * @return true if this collection changed as a result of the call
     */
    @Override
    public boolean addAll(Collection<? extends Vegetable> c) {
        boolean modified = false;
        for (Vegetable vegetable : c){
            if (add(vegetable)){
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in this collection that are contained in the specified collection (optional operation).
     * In other words, removes from this collection all of its elements that are not contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this set
     * @return true if this collection changed as a result of the call
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node current = head;
        while (current != null){
            if (!c.contains(current.data)){
                Node elementToRemove = current.next;
                current = current.next;
                remove(elementToRemove.data);
                modified = true;
            } else {
                current = current.next;
            }
        }
        return modified;
    }

    /**
     * Removes all of this collection's elements that are also contained in the specified collection (optional operation).
     * After this call returns, this collection will contain no elements in common with the specified collection.
     *
     * @param c collection containing elements to be removed from this set
     * @return true if this collection changed as a result of the call
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c){
            if (remove(o)){
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all the elements from this collection (optional operation). The collection will be empty after this method returns.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
