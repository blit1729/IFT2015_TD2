

/*
 * Section: 4. File circulaire...
 */

public class File {
    private int[] circularArray;
    private int head = -1;
    private int tail = -1;
    private int length = 0;
    private final int MAX_SIZE = 100;

    public File() {
        this.circularArray = new int[MAX_SIZE];
    }

    // Ajouter un élément à la file circulaire

    public void push(int element) {

        if (((tail == MAX_SIZE - 1) && (head == 0)) || (tail == head - 1)) {
            System.out.println("La file est pleine !");
            return;
        }

        if (head == -1) {
            head = 0;
            tail = 0;
            circularArray[head] = element;
            length++;
            return;
        }

        tail = ++tail % MAX_SIZE;
        circularArray[this.tail] = element;
        length++;
    } // fin

    // Retirer un élément de la file circulaire
    public int pop() {
        // la file est vide
        if (head == -1) {
            System.out.println("La file est vide !");
            return -1;
        }
        if (tail == head) {
            // derniere element de la file
            int value1 = circularArray[head];
            head = -1;
            tail = -1;
            length--;
            return value1;
        }
        // cas normal
        int value2 = circularArray[head];
        head = ++head % MAX_SIZE;
        length--;
        return value2;
    }

    // Renvoie la longueur de la file circulaire
    public int length() {
        return length;
    }

    // Affiche la liste circulaire

    public void print() {

        if (length == 0) {
            System.out.println("La liste est vide");
            return;
        }

        String valToPrint = "(";
        for (int i = 0; i < length; i++) {
            int tempPop = pop();
            valToPrint = valToPrint + tempPop;
            push(tempPop);
            if (i != (length - 1)) {
                valToPrint = valToPrint + ",";
            }
        }

        System.out.println(valToPrint + ")");

    }

    // Renvoie true si l'element est dans la liste, false sinon

    public boolean search(int element) {

        boolean elemExist = false;

        for (int i = 0; i < length; i++) {

            int tempPop = pop();
            if (tempPop == element) {
                elemExist = true;
            }
            push(tempPop);
        }

        return elemExist; // return the found element 
    }

    // Retire la première apparition de la valeur

    public void remove(int value) {

        int numTimeElementFound = 0;
        for (int i = 0; i < length; i++) {

            int tempPop = pop();

            if (tempPop == value) {
                numTimeElementFound++;
            }

            if ((tempPop != value) || ((tempPop == value) && (numTimeElementFound != 1))) {

                push(tempPop);
            }

        }

        if (numTimeElementFound != 0) {

            push(pop());

        }

    }

}
