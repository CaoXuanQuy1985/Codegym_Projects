package com.codegym;

public class UserController {
    UserStorage storage;
    public UserController(UserStorage storage) {
        this.storage = storage;
    }
    public void store() {
        storage.store();
    }
}
