class LRUCache {
    class Node{
     int key, value;
     Node prev, next;

     Node(int k, int v){
        key = k;
        value = v;
     }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
         head = new Node(0, 0);
         tail = new Node(0,0);
         head.next = tail;
         tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);

        remove(node);
        insertToTail(node);

        return node.value;
    }
    
     public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()== capacity){
            remove(head.next);
        }

        Node newNode =  new Node(key, value);
        insertToTail(newNode);
    }


    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

        private void insertToTail(Node node){
        map.put(node.key, node);

        Node prevTail = tail.prev;
        prevTail.next = node;
        node.prev = prevTail;

        node.next = tail;
        tail.prev = node;
    }
}
