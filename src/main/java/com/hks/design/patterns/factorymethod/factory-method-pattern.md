# Factory Method <!-- aka Virtual Constructor -->
aka __Virtual Constructor__
<!-- https://www.javatpoint.com/factory-method-design-pattern -->
Define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses  are responsible to create the instance of the class.

## Advantages
1. Allows the subclasses to choose the type of objects to create.
2. Promotes __loose-coupling__ by eliminating the need to bind application-specific classes into the code. -> code interacts solely with the resultant interface or abstract class, so it'll work with any classes that implement the interface or that extends the abstract class.

## Usage
1. When a class doesn't know what sub-classes will be required to create.
2. When a class wants that it's subclasses specify the objects to be created.
3. When the parent classes choose the creation of objects to its subclasses.

