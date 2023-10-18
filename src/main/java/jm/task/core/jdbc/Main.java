package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Vasiliy", "Petrov", (byte) 42);
        userService.saveUser("Ivan", "Popov", (byte) 24);
        userService.saveUser("Fedor", "Makarov", (byte) 33);
        userService.saveUser("Maksim", "Borisov", (byte) 30);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}
