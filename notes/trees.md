# Algoritmos de Percursos em Árvores Binárias

## Pré-ordem (Pre-order)
**Ordem:** Raiz → Esquerda → Direita  
**Uso ideal:** Quando você precisa processar a raiz antes das subárvores

```java
public void preOrder(TreeNode root) {
    if (root != null) {
        System.out.print(root.val + " "); // Processa raiz primeiro
        preOrder(root.left);              // Subárvore esquerda
        preOrder(root.right);             // Subárvore direita
    }
}
```

**Exemplo de saída:**  
Para a árvore:
```
    1
   / \
  2   3
 / \
4   5
```
Resultado: `1 2 4 5 3`

## Em-ordem (In-order)
**Ordem:** Esquerda → Raiz → Direita  
**Uso ideal:** Para árvores binárias de busca, visita os nós em ordem crescente

```java
public void inOrder(TreeNode root) {
    if (root != null) {
        inOrder(root.left);               // Subárvore esquerda primeiro
        System.out.print(root.val + " "); // Processa raiz
        inOrder(root.right);              // Subárvore direita
    }
}
```

**Exemplo de saída:**  
Mesma árvore acima → `4 2 5 1 3`

## Pós-ordem (Post-order)
**Ordem:** Esquerda → Direita → Raiz  
**Uso ideal:** Quando você precisa processar as subárvores antes da raiz 

```java
public void postOrder(TreeNode root) {
    if (root != null) {
        postOrder(root.left);              // Subárvore esquerda
        postOrder(root.right);             // Subárvore direita
        System.out.print(root.val + " ");  // Processa raiz por último
    }
}
```

**Exemplo de saída:**  
Mesma árvore → `4 5 2 3 1`
