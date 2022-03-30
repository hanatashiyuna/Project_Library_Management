package com.example.vido_manager_library.Models;

import java.io.Serializable;
/**
 * pbSc = publishing company
 */

public class HomeHorModels implements Serializable {
    private int  typeNumber,bookshelf, amountBooks, bookId, image;
    private String bookNumber, bookName, author, pbSC;
    public static final int TYPE_BOOK_1 = 1,TYPE_BOOK_2 = 2, TYPE_BOOK_3 = 3;

    public HomeHorModels(int bookId) {
        this.bookId = bookId;
    }

    public HomeHorModels(int image, String bookName) {
        this.image = image;
        this.bookName = bookName;
    }

    public HomeHorModels(int image, String bookName, int bookId){
        this.bookName = bookName;
        this.bookId = bookId;
        this.image = image;
    }

    public HomeHorModels(String bookNumber, int typeNumber, int bookshelf, int amountBooks, int bookId, int image, String bookName, String author, String pbSC) {
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

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
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

    public static int getTypeBook1() {
        return TYPE_BOOK_1;
    }

    public static int getTypeBook2() {
        return TYPE_BOOK_2;
    }

    public static int getTypeBook3() {
        return TYPE_BOOK_3;
    }
}
