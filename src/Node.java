public class Node {
  int value;
  Node next;

  /*
   * 3.1 Mise en place des bases
   */

  /*
   * constructeur
   * 
   */
  public Node(int value) {
    this.value = value;
    this.next = null;

  }

  /*
   * constructeur
   * 
   */
  public Node(int value, Node next) {
    this.value = value;
    this.next = next;
  }

    /*
   * Pour ajouter un element a la fin de la liste
   * 
   * 
   */

  public void addValue(int value) {

    // si on est sur le derniere node de la liste
    if (this.next == null) {
      this.next = new Node(value);
    }

    // sinon, on va aller d'un maniere recursif jusqua le derniere node
    // pour ajouter un nouveau element dans un nouveau node

    else {
      this.next.addValue(value);
    }
  } //fin

  /*
   * pour ajouter un nouveau node a la fin de la liste
   */
  public void addNode(Node next) {

    // Si on est deja sur le derniere node, on ajoute directement
    if (this.next == null) {
      this.next = next;
    }
    // Sinon, on parcourit recursivement jusqua le derniere node, puis on ajoute un
    // nouveau
    else {
      this.next.addNode(next);
    }
  }

  /*
   * pour retirer le derniere element et son node dans lequel il se trouve.
   */

  public void removeLast() {
    // on est sur le derniere node, donc on fait rien , on finit la recherche
    if (this.next == null) {
      return;
    }

    // on est sur l'avanr dernier puis on enleve le dernier
    if (this.next.next == null) {
      this.next = null;
    }
    // on continue le processus jusqua on arrive au avant dernier node.
    else {
      this.next.removeLast();
    }
  }

  // Retirer tous les elements avec une certaine valeur

  public void removeValue(int value) {

    // la fin de la liste, on peut rien faire
    if (this.next == null) {

      return;
    }

    // si l'element desiré est sur le prochaine node,
    // alors on connect le node actual avec le prochain prochain node

    else if (next.value == value) {

      next = next.next;

      // on cherche si il ya un autre element avec la meme valuer
      removeValue(value);
    }

    // sinon, on continue notre recherche jusqua on trouve un element desiré sur le
    // prochaine node
    else {
      // Keep searching for the value to remove
      next.removeValue(value);
    }
  }

  

  // method iteratif pour trouver le longuer de la liste

  public int length_Iteratif() {
    int length = 0;

    Node nodeActual = this;
    // tanque il ya le node prochaine, on counte, puis on passe a la prochaine node.
    while (nodeActual != null) {
      length++;
      nodeActual = nodeActual.next;
    }
    return length;
  }

  // method recursif pour trouver le longuer de la liste

  public int length_Recursion() {

    // si la liste contient un seul node
    if (this.next == null) {
      return 1;
    }

    // chaque fois la method s'appele jusqua arriver au dernier node
    return 1 + this.next.length_Recursion();
  }

  // cette method retourne n'eme element apartir de la fin en O(n)

  public int returnNlast(int nLast) {
    Node nodeActual;

    int length = length_Iteratif(); // O(n)

    // pour counter l'element apartir de la fin
    int targetIndex = length - nLast;
    nodeActual = this;

    // O(n)
    for (int i = 0; i < targetIndex; i++) {
      nodeActual = nodeActual.next;
    }
    return nodeActual.value; // le resultat final est en O(2n) qui revient O(n)
  }

  /*
   * 3.2 Implementation d'une fonction de tri
   * 
   */

  public void addValue_Ordered(int value) {

    // si on est sur le derniere node
    if (this.next == null) {
      this.next = new Node(value);
    }
    // si le value est plus petit que celui du prochaine node

    else if (this.next.value > value) {
      this.next = new Node(value, this.next);
    } else {
      this.next.addValue_Ordered(value);
    }
  }

  // trie une liste chainée

  public void insertSort() {

    Node nodeActual = this;
    // tanque il ya des nodes
    while (nodeActual != null) {
      // on garrde le prochaine node dans une variable
      Node prochainNode = nodeActual.next;

      // on ajoute le value de actual node dans la liste triée
      addValue_Ordered(nodeActual.value);
      // on passe au prochain node
      nodeActual = prochainNode;
    }
  }  // fin

}
