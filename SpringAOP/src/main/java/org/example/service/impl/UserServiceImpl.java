package org.example.service.impl;

import org.example.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("addUser");
    }

    @Override
    public void updateUser() {
        System.out.println("updateUser");
    }

    @Override
    public void deleteUser() {
        System.out.println("deleteUser");
    }
}
