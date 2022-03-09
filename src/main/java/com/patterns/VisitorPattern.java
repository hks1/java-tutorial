package com.patterns;

public class VisitorPattern {
}

abstract class FileVisitor{
    abstract void visitWord(WordFile f);
    abstract void visitPicture(PictureFile f);
}

abstract class File{
    abstract void visit(FileVisitor fv);
}

class WordFile extends File{
    @Override
    void visit(FileVisitor fv) {
        fv.visitWord(this);
    }
}

class PictureFile extends File{
    @Override
    void visit(FileVisitor fv) {
        fv.visitPicture(this);
    }
}

class PrintFileVisitor extends FileVisitor{
    @Override
    public void visitWord(WordFile f) {
        System.out.println("Open word and print wor doc");
    }

    @Override
    public void visitPicture(PictureFile f) {
        System.out.println("Open picture viewer and print picture");
    }
}

class TestVisitorPattern {
    public static void main(String[] args) {
        File[] files = {new PictureFile(), new WordFile()};
        FileVisitor v = new PrintFileVisitor();
        for(File f : files){
            f.visit(v);
        }
    }
}
