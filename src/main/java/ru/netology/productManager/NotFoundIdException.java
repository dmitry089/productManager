package ru.netology.productManager;

public class NotFoundIdException extends RuntimeException {
    public NotFoundIdException(String msg) {
        super(msg);
    }

}
