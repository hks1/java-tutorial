# Adapter Pattern

An adapter pattern acts as a connector between two incompatible interfaces that otherwise cannot be connected directly.

> convert an existing interface into another interface that the client expects

## Example

```mermaid
classDiagram
MovableAdapter <-- Client : target
MovableAdapter <|.. MovableAdapterImpl
Movable <-- MovableAdapterImpl : adaptee
class MovableAdapter{
<<interface>>
+speed() double
}
class MovableAdapterImpl{
-Movable luxuryCars
+speed() double
}
class Movable{
+speed() double
}
Movable returns speed im MPH
MovableAdapter returns speed in KMPH
```
