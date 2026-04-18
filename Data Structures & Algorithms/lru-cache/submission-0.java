class LRUCache {

    // Hashmap + Doubly linked list approach. as we need get and put with O(1)
    class Node{
        int key;
        int value;
        Node prev=null, next=null;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> hmap1;
    Node head,tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hmap1 = new HashMap<>();
        head = new Node(0,0); // dummy node.
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hmap1.containsKey(key)){
            Node node1 = hmap1.get(key);
            moveToTail(node1);
            return node1.value;
        }
        return -1;
    }

    public void removeFront(){
        Node node1 = head.next;
        removeNode(node1);
        hmap1.remove(node1.key);
    }

    public void moveToTail(Node node1){
        removeNode(node1);
        addToTail(node1);
    }

    public void addToTail(Node node1){
        // insert ahead of tail. to prevent null checks for removal.
        node1.prev = tail.prev;
        tail.prev.next = node1;
        tail.prev = node1;
        node1.next = tail;
    }

    public void removeNode(Node node1){
        node1.prev.next = node1.next;
        node1.next.prev = node1.prev;
    }
    
    public void put(int key, int value) {
        // preexisting
        if(hmap1.containsKey(key)){
            Node n1 = hmap1.get(key);
            removeNode(n1);
            n1.value = value;
            addToTail(n1);
            hmap1.put(key, n1);
            return;
        }
        if(hmap1.size() == capacity){
            // remove the front
            removeFront();
        }
        Node node1 = new Node(key,value);
        hmap1.put(key, node1);
        addToTail(node1);
    }
        
}
