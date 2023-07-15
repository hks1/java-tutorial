# Collections

## Comparator and Comparable

```java
public class Player {
    private int ranking;
    private String name;
    private int age;
    
    // constructor, getters, setters  
}
```

**Comparable** is an interface defining a strategy of comparing an object with other objects of the same type. This is called the class's “natural ordering.”

In order to be able to sort, we must define our Player object as comparable by implementing the Comparable interface:

```java
public class Player implements Comparable<Player> {

    // same as before

    @Override
    public int compareTo(Player otherPlayer) {
        return Integer.compare(getRanking(), otherPlayer.getRanking());
    }

}

```

**The sorting order is decided by the return value of the compareTo() method.** The Integer.compare(x, y) returns -1 if x is less than y, 0 if they're equal, and 1 otherwise.



The **Comparator** interface defines a compare(arg1, arg2) method with two arguments that represent compared objects, and works similarly to the Comparable.compareTo() method.

```java
public class PlayerRankingComparator implements Comparator<Player> {

    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
       return Integer.compare(firstPlayer.getRanking(), secondPlayer.getRanking());
    }

}
```

```java
public class PlayerAgeComparator implements Comparator<Player> {

    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
       return Integer.compare(firstPlayer.getAge(), secondPlayer.getAge());
    }

}
```

```java
PlayerRankingComparator playerComparator = new PlayerRankingComparator();
Collections.sort(footballTeam, playerComparator);

```

Java 8 Comparators
> using lambda expressions and the `comparing()` static factory method


lambda expression

```java
Comparator byRanking = 
  (Player player1, Player player2) -> Integer.compare(player1.getRanking(), player2.getRanking());
```

Comparator.comparing() method

```java
Comparator<Player> byRanking = Comparator
  .comparing(Player::getRanking);
Comparator<Player> byAge = Comparator
  .comparing(Player::getAge);
```


Comparator vs Comparable

- Sometimes we can't modify the source code of the class whose objects we want to sort, thus making the use of Comparable impossible
- Using Comparators allows us to avoid adding additional code to our domain classes
- We can define multiple different comparison strategies, which isn't possible when using Comparable

Avoiding the subtraction trick

Over the course of this tutorial, we've used the Integer.compare() method to compare two integers. However, one might argue that we should use this clever one-liner instead:
```java
Comparator<Player> comparator = (p1, p2) -> p1.getRanking() - p2.getRanking();
```

Although it's much more concise than other solutions, it can be a victim of integer overflows in Java:

```java
Player player1 = new Player(59, "John", Integer.MAX_VALUE);
Player player2 = new Player(67, "Roger", -1);

List<Player> players = Arrays.asList(player1, player2);
players.sort(comparator);
```

# [List](https://github.com/hks1/java-tutorial/blob/main/src/main/java/com/tutorial/collections/collection/list/list.md)

## Iterable

## Iterator



<!-- https://www.baeldung.com/java-comparator-comparable -->
<!-- https://www.baeldung.com/java-8-comparator-comparing -->
