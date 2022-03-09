package com.patterns;

public class CommandPattern {
}

class Document{
    String text = "";
}

abstract class DocumentCommand{
    Document document;
    DocumentCommand(Document document) { this.document = document;}
    abstract void execute();
    abstract DocumentCommand createUndo();
}

class AddCharCommand extends DocumentCommand{
    char c;

    AddCharCommand(Document document, char c){
        super(document);
        this.c = c;
    }

    @Override
    void execute() {
        document.text += c;
    }

    @Override
    DocumentCommand createUndo() {
        return new DeleteCharCommand(document);
    }
}

class DeleteCharCommand extends DocumentCommand{
    DeleteCharCommand(Document document){
        super(document);
    }

    @Override
    void execute() {
        document.text = document.text.substring(0, document.text.length() - 1);
    }

    @Override
    DocumentCommand createUndo() {
        return null;
    }
}

class TestCommandPattern{
    public static void main(String[] args) {
        Document d = new Document();
        DocumentCommand[] cs = {new AddCharCommand(d, 'H'), new AddCharCommand(d, 'I')};
        for(DocumentCommand c : cs){
            c.execute();
        }
        System.out.println(">>" + d.text);
        for(DocumentCommand c : cs) c.createUndo().execute();
        System.out.println(">>" + d.text);
    }
}
