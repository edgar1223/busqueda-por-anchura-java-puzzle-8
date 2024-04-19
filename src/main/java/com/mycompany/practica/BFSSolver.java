/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;



/**
 *
 * @author Edgar David
 */
public class BFSSolver {
  


    public static ResutaldoBusqueda bfs(int[][] initial, int[][] goal) {
        Queue<Node> openSet = new Queue<>();
    MyHashSet<String> visited = new MyHashSet<>();

    // Agrega el estado inicial a OpenSet
    openSet.enqueue(new Node(initial, 0, null));

    // Mientras OpenSet no esté vacío
    while (!openSet.isEmpty()) {
        // Remueve un nodo de OpenSet
        Node actual = openSet.dequeu();

        // Si el nodo contiene el estado objetivo, retorna la solución
        if (Node.deepEquals(actual.estado, goal)) {
return new ResutaldoBusqueda(actual, new MyHashSet<Node>(openSet.toList()), visited);
        }

        // Agrega el estado actual a la lista de visitados
        visited.add(MyArrays.deepToString(actual.estado));

        // Agrega nodos resultantes
        AgregaNodoVecino(actual, openSet, visited, goal);
    }

    // Si no se encuentra una solución, retorna null
   return new ResutaldoBusqueda(null, new MyHashSet<>(openSet.toList()), visited);

    }

    public static void AgregaNodoVecino(Node actual, Queue<Node> openSet, MyHashSet<String> visited, int[][] goal) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Direcciones: arriba, abajo, izquierda, derecha

        // Encuentra la posición del cero en el estado actual
        int zeroRow = -1, zeroCol = -1;
        outerloop:
        for (int i = 0; i < actual.estado.length; i++) {
            for (int j = 0; j < actual.estado[0].length; j++) {
                if (actual.estado[i][j] == 0) {
                    zeroRow = i;
                    zeroCol = j;
                    break outerloop;
                }
            }
        }

        // Genera nuevos estados moviendo el cero en todas las direcciones posibles
        for (int[] dir : directions) {
            int newRow = zeroRow + dir[0];
            int newCol = zeroCol + dir[1];

            // Verifica si la nueva posición es válida
            if (newRow >= 0 && newRow < actual.estado.length && newCol >= 0 && newCol < actual.estado[0].length) {
                // Copia el estado actual para modificarlo
                int[][] newState = copiarestado(actual.estado);

                // Intercambia el valor del cero con el valor en la nueva posición
                int temp = newState[zeroRow][zeroCol];
                newState[zeroRow][zeroCol] = newState[newRow][newCol];
                newState[newRow][newCol] = temp;

                // Verifica si el nuevo estado no ha sido visitado ni está en OpenSet
                if (!visited.contains(MyArrays.deepToString(newState)) && !contienoEstado(openSet, newState)) {
                    // Calcula el costo para llegar al nuevo estado (en este caso, distancia recorrida)
                    int newCost = actual.costo + 1;

                    // Agrega el nuevo estado a OpenSet
                    openSet.enqueue(new Node(newState, newCost, actual));
                }
            }
        }
    }

    public static int[][] copiarestado(int[][] state) {
        int[][] newState = new int[state.length][];
        for (int i = 0; i < state.length; i++) {
            newState[i] = MyArrays.copyOf(state[i], state[i].length);
        }
        return newState;
    }

    private static boolean contienoEstado(Queue<Node> queue, int[][] estado) {
        for (Node node : queue) {
            if (Node.deepEquals(node.estado, estado)) {
                return true;
            }
        }
        return false;
    }

    public static void printSolution(Node solution) {
        if (solution == null) {
            System.out.println("No se encontró solución.");
            return;
        }

        // Recorre la ruta desde el estado final hasta el estado inicial
        MyStack<Node> path = new MyStack<>();
        Node current = solution;
        while (current != null) {
            path.push(current);
            current = current.padre;
        }

        // Imprime la ruta y el costo mínimo
        System.out.println("Ruta hacia la solución:");
        int step = 0;
        while (!path.isEmpty()) {
            Node node = path.pop();
            System.out.println("Paso " + step + ":");
            printState(node.estado);
            System.out.println("Costo acumulado: " + node.costo);
            step++;
        }
    }

    public static void printState(int[][] state) {
        for (int[] row : state) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}