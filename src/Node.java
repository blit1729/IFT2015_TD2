public class Node {
    private int value;
    private Node next = null;
    

    public Node(int value){
        this.value = value;
    }

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public void addValue(int value){
        this.value = value;
    }

    // Ajouter le noeud donnée en argument à la liste chainée
    public void addNode(Node next){
        while
    }

    public void removeLast(){
        // TODO
    }

    public void removeValue(int value){
        // TODO
    }

    public int length_iteratif(){
        // TODO
        return 0;
    }

    public int length_recurssion(){
        // TODO
        return 0;
    }

    public int returnNlast(int nLast){
        // TODO
        return 0;
    }

    public void addValue_ordered(int value){
        // TODO
    }

    public void insertSort(){
        // TODO
    }
    
    
    
    // Getters
    
    public int getValue(){
        return this.value;
    }
    
    public Node getNext(){
        return this.next;
    }
}
