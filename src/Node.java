public class Node {

    int element;
    Node left;
    Node right;
    Node parent;

    // construtor da classe Node é usado para inicializar os nós quando eles são criados.
    // O construtor recebe argumentos (como valores iniciais) e configura os atributos do
    // objeto de acordo com esses valores. Isso é especialmente útil quando você cria um
    // novo nó durante a inserção na árvore.
    Node(int value) {
        element = value;
        left = right = parent = null;
    }

}
