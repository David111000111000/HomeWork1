public class SinglyLinkedList<T> {

    // Класс Node представляет узел списка
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // Головной узел списка
    private int size=0;
    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        // Если список пуст, то добавляем новый узел в качестве головного
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            // Переходим к последнему узлу в списке
            while (current.next != null) {
                current = current.next;
            }
            // Добавляем новый узел в конец списка
            current.next = newNode;
        }
        size++;
    }

    public void remove(T data) {
        // Если список пуст, то ничего не делаем
        if (head == null) {
            return;
        }
        // Если первый узел - удаляемый, то делаем второй узел головным
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }
        // Иначе ищем узел со значением data
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                // Удаляем найденный узел
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        size--;
    }
    public T get(int index) throws Exception {
        if(index>size-1||index<0) throw new Exception("Почему?");
        Node<T> elem=head;
        for(int i=0;i<index;i++){
            elem=elem.next;
        }
        return elem.data;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        myList.printList(); // Вывод: 1 -> 2 -> 3 -> 4 -> 5 -> null

        myList.remove(1);

        myList.printList(); // Вывод: 1 -> 2 -> 4 -> 5 -> null
        try {
            System.out.println(myList.get(3));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(myList.size);
    }
}