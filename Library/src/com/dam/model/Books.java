package com.dam.model;

import java.util.Date;

public class Books {
    private String ISBN;
    private String Tittle;
    private String Author;
    private Date PublishingDate;
    private String Editorial;
    private enum Genre{
        NOVEL, SCI_FI, HISTORY, FANTASY, THRILLER, CHILDISH, POESY, DRAMA, BLACK_NOVEL, HORROR, COMIC
    }
    private int CopiesQuantity;
    private int LoansCopiesQuantity;
    private enum Status{
        AVAILABLE, LOANED, RESERVED
    }

}
