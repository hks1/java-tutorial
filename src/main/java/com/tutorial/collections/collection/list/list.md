//list




```mermaid
classDiagram
Collection~E~ <|-- List~E~
class List~E~{
<<interface>>
+ boolean add(int index, E)
+ boolean addAll(int index, Collection<E>)
+ void clear()
+ boolean contains(Object o)
+ boolean containsAll(Collection c)
+ E get(int index)
+ int lastIndexOf(Object o)
+ E remove(int index)
+ E set(int index, E)
+ Iterator<E> iterator()
+ ListIterator<E> listIterator()
+ List<E> subList(int fromIndex, int toIndex)
+ int size()
+ boolean isEmpty()
}
```


#

```mermaid
classDiagram
class `List~E~`{
<<interface>>

}
```

<!-- https://mermaid.js.org/syntax/classDiagram.html -->
