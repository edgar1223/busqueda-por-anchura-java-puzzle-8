/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.Arrays;

/**
 *
 * @author Edgar David
 */
public  class Node {
      int[][] estado;
        int costo;
        Node padre;

        public Node(int[][] estado, int costo, Node padre) {
            this.estado = estado;
            this.costo = costo;
            this.padre = padre;
        }
        @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int[] row : estado) {
        sb.append(MyArrays.toString(row)).append("\n");
    }
    return sb.toString();
}
     // Método para verificar si dos matrices de enteros son iguales de manera profunda
    public static boolean deepEquals(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            if (!Arrays.equals(matrix1[i], matrix2[i])) {
                return false;
            }
        }
        return true;
    }
}
