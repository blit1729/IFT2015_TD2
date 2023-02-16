public class App {
    public static void main(String[] args) throws Exception {
        Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		System.out.println(node1.getValue());
		System.out.println(node2.getValue());
		System.out.println(node3.getValue());
		
		node1.addNode(node2);
		
		
		System.out.println(node1.getNext().getValue());
    }
}
