package com.example.vido_manager_library.Models;

public class HomeHorModels {
    private int bookNumber, typeNumber,bookshelf, amountBooks, bookId, image;
    private String bookName, author, pbSC;

    public HomeHorModels(int bookId) {
        this.bookId = bookId;
    }

    public HomeHorModels(int image, String bookName) {
        this.image = image;
        this.bookName = bookName;
    }

    public HomeHorModels(int bookNumber, int typeNumber, int bookshelf, int amountBooks, int bookId, int image, String bookName, String author, String pbSC) {
        this.bookNumber = bookNumber;
        this.typeNumber = typeNumber;
        this.bookshelf = bookshelf;
        this.amountBooks = amountBooks;
        this.bookId = bookId;
        this.image = image;
        this.bookName = bookName;
        this.author = author;
        this.pbSC = pbSC;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(int typeNumber) {
        this.typeNumber = typeNumber;
    }

    public int getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(int bookshelf) {
        this.bookshelf = bookshelf;
    }

    public int getAmountBooks() {
        return amountBooks;
    }

    public void setAmountBooks(int amountBooks) {
        this.amountBooks = amountBooks;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPbSC() {
        return pbSC;
    }

    public void setPbSC(String pbSC) {
        this.pbSC = pbSC;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
