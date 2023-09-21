public class BinaryTree {
    Node root;

    // O construtor da classe Tree também serve para inicializar a árvore.
    // Ele pode aceitar argumentos, como um valor inicial para a raiz da árvore
    // , e criar o objeto da árvore com esse valor configurado.

    // Árvore Vazia:
    //
    // Se você não tem um valor inicial ou se ainda não possui os dados para preencher o nó raiz, pode ser útil começar com uma árvore vazia.
    // Isso permite que você insira valores à medida que eles se tornam disponíveis ou à medida que a lógica da sua aplicação exige.
    //
    // Árvore com Nó Raiz:
    //
    // Se você tem um valor específico que faz sentido para ser o ponto de partida da sua árvore, pode ser útil criar a árvore com esse valor no nó raiz.
    // Isso pode ser particularmente útil quando você tem uma estrutura de dados pré-existente que você deseja representar como uma árvore.
    //
    // Caso Base para Algoritmos Recursivos:
    //
    // Em algoritmos recursivos que percorrem ou manipulam árvores, o nó raiz pode servir como o ponto de partida para a recursão.
    // No entanto, em certos algoritmos, você pode iniciar com uma árvore vazia e expandir a partir daí.

    // Esse construtor é usado quando você deseja criar uma árvore vazia.
    BinaryTree() {
        root = null;
    }

    // Esse construtor é usado quando você deseja criar uma árvore com um nó
    // raiz inicializado com um valor específico.
    BinaryTree(int value) {
        root = new Node(value);
    }

    // A função insert possui dois métodos sobrecarregados: um método público
    // (void insert(int value)) que é chamado externamente para iniciar a inserção
    // e um método privado (Node insert(Node root, int value)) que é chamado recursivamente
    // para realizar a inserção.

    // O método público insert(int value) simplesmente redireciona a chamada para o método privado,
    // passando a raiz atual da árvore (root) e o valor a ser inserido.
    void insert(int value) {
        root = insert(root, value, null);
    }

    Node insert(Node root, int value, Node parent) {

        // No método privado insert(Node root, int value), a primeira coisa que fazemos é verificar
        // se o nó atual (root) é nulo. Se for nulo, isso significa que estamos em uma posição onde
        // um novo nó pode ser inserido. Portanto, criamos um novo nó com o valor fornecido e o retornamos.
        // Isso efetivamente insere o valor na árvore.

        if (root == null) {
            Node newNode = new Node(value);
            newNode.parent = parent; // Defina o pai do novo nó
            return newNode;
        }

        if (value < root.element) {

            // Se o nó atual não for nulo, comparamos o valor a ser inserido com o valor do nó atual
            // (root.element). Se o valor for menor que o valor do nó atual, sabemos que precisamos
            // inserir o novo valor na subárvore esquerda. Portanto, chamamos recursivamente o método
            // insert para a subárvore esquerda (root.left = insert(root.left, value)).

            root.left = insert(root.left, value, root);
        } else {

            // Se o valor for maior ou igual ao valor do nó atual, sabemos que precisamos inserir o novo
            // valor na subárvore direita. Portanto, chamamos recursivamente o método insert para a subárvore
            // direita (root.right = insert(root.right, value)).

            root.right = insert(root.right, value, root);
        }

        // Após realizar a inserção recursiva, o método retorna o nó atual (root). Isso garante que as alterações
        // feitas durante a inserção sejam refletidas na estrutura da árvore.

        return root;
    }

    //aproveitar recursividade de busca usando metodo privado e o publico como feito no root (sobrecarga do metodo)

    Node search(int value) {
        return search(root, value);
    }

    Node search(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (root.element == value) {
            return root;
        } else {
            if (value < root.element) {
                return search(root.left,value);
            } else {
                return search(root.right,value);
            }
        }
    }

    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.element + " ");
            inorderTraversal(root.right);
        }
    }
    void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.element + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.element + " ");
        }
    }
    void printTreeStructure(Node root, String indent) {
        if (root != null) {
            System.out.println(indent + "|- " + root.element);

            if (root.left != null || root.right != null) {
                printTreeStructure(root.right, indent + "   |");
                printTreeStructure(root.left, indent + "   ");
            }
        }
    }

    // A sequência in-order é um tipo de travessia (ou percurso) utilizada em árvores binárias. Ela é chamada "in-order"
    // porque visita os nós da árvore na ordem correta para obter uma sequência ordenada dos valores contidos na árvore.
    // A sequência in-order é definida da seguinte forma:
    //
    // Visita o nó filho esquerdo.
    // Visita o próprio nó.
    // Visita o nó filho direito.
    //
    // Essa sequência de visitas garante que os valores sejam visitados em ordem crescente (do menor para o maior) em uma
    // árvore binária de busca (BST). Isso ocorre porque, ao visitar primeiro o nó esquerdo, você alcança o nó com o menor
    // valor na árvore. Em seguida, visita o próprio nó, o que significa que você está visitando o valor do próprio nó.
    // Por fim, visita o nó filho direito, que conterá o próximo valor mais alto na árvore.
    //
    // A sequência in-order é amplamente utilizada para obter uma lista ordenada dos valores de uma árvore binária de busca.
    // Ela também é usada para percorrer uma árvore de forma ordenada, facilitando a busca por valores específicos ou a
    // realização de operações em ordem crescente.
    //
    //
    void delete(int value){
        Node node = search(value);

        // checamos que ele tem pai e veremos se ele é filho esquerdo ou direto, assim o deixando nulo.
        // caso1

        if (node.left == null && node.right == null) {
            if (node.parent != null) {
                // O nó não é a raiz da árvore
                if (node == node.parent.left) {
                    // Subcaso 1.1: Nó é filho esquerdo do pai
                    node.parent.left = null;
                } else {
                    // Subcaso 1.2: Nó é filho direito do pai
                    node.parent.right = null;
                }
            } else {
                // Caso especial: o nó a ser excluído é a raiz da árvore
                root = null;
            }
        }

        // caso2
        else if(node.left == null || node.right == null) {
            // Subcaso 2.1: Nó é filho esquerdo e seu filho é esquerdo
            if (node.parent != null && node == node.parent.left && node.left != null) {
                node.parent.left = node.left;
                node.left.parent = node.parent;
                return;
            }

            // Subcaso 2.2: Nó é filho esquerdo e seu filho é direito
            if (node.parent != null && node == node.parent.left) {
                node.parent.left = node.right;
                node.right.parent = node.parent;
                return;
            }

            // Subcaso 2.3: Nó é filho direito e seu filho é esquerdo
            if (node.parent != null && node == node.parent.right && node.left != null) {
                node.parent.right = node.left;
                node.left.parent = node.parent;
                return;
            }

            // Subcaso 2.4: Nó é filho direito e seu filho é direito
            if (node.parent != null && node == node.parent.right) {
                node.parent.right = node.right;
                node.right.parent = node.parent;
                return;
            }
        }

        //caso3
        else {
            // Encontrar o sucessor (nó mínimo à direita) (o sucessor in-order )
            Node successor = minimum(node.right);

            // Excluir o sucessor (pode ser um caso 1 ou caso 2)
            if (successor.parent.left == successor) {
                successor.parent.left = null;
            } else {
                successor.parent.right = null;
            }

            // Copiar os dados do sucessor para o nó atual a ser deletado
            node.element = successor.element;
        }

    }
    Node minimum(Node node) {
        if (node.left != null) {
            return minimum(node.left);
        }
        return node;
    }

}
