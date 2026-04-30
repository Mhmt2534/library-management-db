package com.turkcell.library_management.exception;

public class BookAlreadyExist extends BusinessException{

    public BookAlreadyExist() {
        super("Book already exists");
    }

}
