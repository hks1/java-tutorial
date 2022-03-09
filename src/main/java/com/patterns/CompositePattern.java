package com.patterns;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
}

abstract class MenuComponent{
    String text;

    MenuComponent(String text){
        this.text = text;
    }

    @Override
    public String toString() {
        return "MenuComponent{" +
                "text='" + text + '\'' +
                '}';
    }
}

class MenuItem extends MenuComponent{
    MenuItem(String text){
        super(text);
    }
}

class Menu extends MenuComponent{
    List<MenuComponent> components = new ArrayList<>();

    Menu(String text){
        super(text);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "text='" + text + '\'' +
                ", components=" + components +
                '}';
    }
}

class CompositePatternTest {
    public static void main(String[] args) {
        Menu file = new Menu("File");
        file.components.add(new MenuItem("Open"));
        file.components.add(new MenuItem("Save"));
        file.components.add(new MenuItem("Exit"));
        Menu recentFiles = new Menu("Recent");
        recentFiles.components.add(new MenuItem("Recently Closed"));
        file.components.add(recentFiles);
        Menu edit = new Menu("Edit");
        System.out.println(file);
    }
}
