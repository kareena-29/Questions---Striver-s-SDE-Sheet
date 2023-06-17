package Day_14;

import java.util.* ;

public class LFUCache {
    class DLLNode{
        int key, val;
        int frequency;
        DLLNode prev, next;

        public DLLNode(int key, int val){
            this.key = key;
            this.val = val;
            // always initialize freq to 1 initially
            this.frequency = 1;
        }
    }

    class DoubleLinkedList{
        int listSize;
        DLLNode head;
        DLLNode tail;

        public DoubleLinkedList(){
            this.listSize = 0;
            this.head = new DLLNode(0,0);
            this.tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }

        // add new node next to the head and increment list size by 1
        public void addNode(DLLNode curNode){
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        // remove the input node and decrese the list size by 1
        public void removeNode(DLLNode curNode){
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }
    // max capacity
    final int capacity;
    // current size
    int curSize;
    // min freq currently
    int minFrequency;
    // normal map as lru
    Map<Integer,DLLNode> cache;
    // map for doubly linked lists
    Map<Integer, DoubleLinkedList> frequencyMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    

// get node value by key, and then update node frequency as well as relocate that node   
    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if(curNode == null){
            return -1;
        }
        updateNode(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        // corner case: check capacity initialization
        if(capacity == 0){
            return;
        }

        // if already present then update value and add it to new frequency
        if(cache.containsKey(key)){
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }else{
            curSize++;
            if(curSize > capacity){
                // we need to remove an element
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }

            // since not above one its a new Node so freq = 1
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key,value);

            // get the list with freq = 1, and then add new Node into the list as well as into LFU Cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1,curList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode curNode){
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        // if the current list is the last list which has lowest frquency and current node is the only one node in
        // list we need to remove the entire list and then increase min frequency value by 1
        if(curFreq == minFrequency && curList.listSize == 0){
            minFrequency++;
        }

        curNode.frequency++;
        // add current node to another list having frequency + 1;
        // if we do not have the list with this frequency initialize it
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }

}

