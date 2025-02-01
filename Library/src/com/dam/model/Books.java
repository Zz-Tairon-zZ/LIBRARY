package com.dam.model;

import java.util.Date;

public class Books {
    private final String ISBN;
    private final String Tittle;
    private final String Author;
    private final Date PublishingDate;
    private final String Editorial;
    private final int CopiesQuantity;
    private final int LoansCopiesQuantity;

    private enum Genre {
        NOVEL, SCI_FI, HISTORY, FANTASY, THRILLER, CHILDISH, POESY, DRAMA, BLACK_NOVEL, HORROR, COMIC
    }

    private enum Status {
        AVAILABLE, LOANED, RESERVED
    }

    public Books(String ISBN, String tittle, String author, Date publishingDate, String editorial, int copiesQuantity, int loansCopiesQuantity) {
        this.ISBN = ISBN;
        Tittle = tittle;
        Author = author;
        PublishingDate = publishingDate;
        Editorial = editorial;
        CopiesQuantity = copiesQuantity;
        LoansCopiesQuantity = loansCopiesQuantity;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTittle() {
        return Tittle;
    }

    public String getAuthor() {
        return Author;
    }

    public Date getPublishingDate() {
        return PublishingDate;
    }

    public String getEditorial() {
        return Editorial;
    }

    public int getCopiesQuantity() {
        return CopiesQuantity;
    }

    public int getLoansCopiesQuantity() {
        return LoansCopiesQuantity;
    }


}
