/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

/**
 *
 * @author Edgar David
 */
public class ResutaldoBusqueda {
   Node solucion;
    MyHashSet<Node> openSet;
    MyHashSet<String> visitado;

    public ResutaldoBusqueda(Node solucion, MyHashSet<Node> openSet, MyHashSet<String> visitado) {
        this.solucion = solucion;
        this.openSet = openSet;
        this.visitado = visitado;
    }
    }
    