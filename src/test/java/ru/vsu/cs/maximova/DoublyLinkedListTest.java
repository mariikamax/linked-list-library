package ru.vsu.cs.maximova;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    public void testAddToEnd() {
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);

        assertEquals(3, list.size());
        assertEquals(1, list.getElementOfIndex(0));
        assertEquals(2, list.getElementOfIndex(1));
        assertEquals(3, list.getElementOfIndex(2));
    }

    @Test
    public void testAddFirst() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertEquals(3, list.size());
        assertEquals(3, list.getElementOfIndex(0));
        assertEquals(2, list.getElementOfIndex(1));
        assertEquals(1, list.getElementOfIndex(2));
    }

    @Test
    public void testAddOfIndex() {
        list.addToEnd(1);
        list.addToEnd(3);
        list.addOfIndex(1, 2);

        assertEquals(3, list.size());
        assertEquals(1, list.getElementOfIndex(0));
        assertEquals(2, list.getElementOfIndex(1));
        assertEquals(3, list.getElementOfIndex(2));
    }

    @Test
    public void testRemoveElement() {
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);

        assertTrue(list.removeElement(2));
        assertEquals(2, list.size());
        assertEquals(1, list.getElementOfIndex(0));
        assertEquals(3, list.getElementOfIndex(1));
    }

    @Test
    public void testRemoveNonExistentElement() {
        list.addToEnd(1);
        list.addToEnd(2);

        assertFalse(list.removeElement(5));
        assertEquals(2, list.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.addToEnd(1);
        assertEquals(1, list.size());
        list.addToEnd(2);
        assertEquals(2, list.size());
        list.removeElement(1);
        assertEquals(1, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.addToEnd(1);
        assertFalse(list.isEmpty());
        list.removeElement(1);
        assertTrue(list.isEmpty());
    }
}
