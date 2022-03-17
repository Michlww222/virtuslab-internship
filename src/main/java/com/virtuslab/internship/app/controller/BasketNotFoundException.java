package com.virtuslab.internship.app.controller;

class BasketNotFoundException extends RuntimeException {

    BasketNotFoundException(long id) {
        super("Could not find employee " + id);
    }
}
