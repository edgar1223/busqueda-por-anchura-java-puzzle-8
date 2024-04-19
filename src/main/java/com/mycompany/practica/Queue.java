/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;


public class Queue<E> implements Iterable<E>{

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E element = current.getElement();
            current = current.getNext();
            return element;
        }
    }
  //---------------- nested Node class ----------------
  /**
   * Node of a queue, which stores a reference to its
   * element and to the subsequent node in the queue (or null if this
   * is the last node).
   */
  private static class Node<E> {
   private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    /** The element stored at this node */
    private E element;

    /** A reference to the subsequent node in the queue */
    private Node<E> next;

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    /** Accessor methods
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    /** Modifier methods
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } /**----------- end of nested Node class ----------- */

  /** instance variables of the Queue */
  /** The head node of the queue (or null if empty) */
  private Node<E> head = null;

  /** The last node of the queue (or null if empty) */
  private Node<E> tail = null;

  /** Number of nodes in the queue */
  private int size = 0;

  /** Constructs an initially empty queue. */
  public Queue() {}

  /**
   * access methods
   * @return number of elements in the queue
   */
  public int size() { return size; }

  /**
   * Tests whether the queue is empty.
   * @return true if the queue is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the first element of the queue
   * @return element at the front of the queue (or null if empty)
   */
  public E peek() {
    if (isEmpty()) return null;
    return head.getElement();
  }

  /**
   * Adds an element to the end of the queue.
   * @param e  the new element to add
   */
  public void enqueue(E e) {                  /** adds element e to the end of the queue */
    Node<E> newest = new Node<>(e, null);    /** node will eventually be the tail */
    if (isEmpty())
      head = newest;                         /** special case: previously empty queue */
    else
      tail.setNext(newest);                  /** new node after existing tail */
    tail = newest;                           /** new node becomes the tail */
    size++;
  }

  /**
   * Removes and returns the first element of the queue.
   * @return the removed element (or null if empty)
   */
  public E dequeu() {                   	 /** removes and returns the first element */
    if (isEmpty()) return null;              /** nothing to remove */
    E answer = head.getElement();
    head = head.getNext();                   /** will become null if queue had only one node */
    size--;
    if (size == 0)
      tail = null;                           /** special case as queue is now empty */
    return answer;
  }
 public List<E> toList() {
    List<E> list = new ArrayList<>();
    Node<E> current = head;
    while (current != null) {
        list.add(current.getElement());
        current = current.getNext();
    }
    return list;
}
  
    
}

