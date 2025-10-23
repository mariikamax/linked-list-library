# Библиотека реализаций связных списков (TASK_13)

Библиотека предоставляет реализации двусвязного и циклического списков на Java.

## Структура

- `LinkedList.java` - интерфейс списка
- `DoublyLinkedList.java` - двусвязный список
- `CircularLinkedList.java` - циклический список
- `Node.java` - узел списка
- `DoublyLinkedListTest.java` - тесты для двусвязного списка
- `CircularLinkedListTest.java` - тесты для циклического списка

## Использование

```java 
// Двусвязный список
DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
list.addToEnd(1);
list.addFirst(0);

// Циклический список
CircularLinkedList<String> circularList = new CircularLinkedList<>();
circularList.addToEnd("A");
```

## Тестирование

Все тесты успешно проходятся.