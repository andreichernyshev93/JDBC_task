package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Bob", "Dilan", (byte) 38);
        System.out.println("User с именем Bob добавлен в базу данных");
        userService.saveUser("Robert", "Lowson", (byte) 31);
        System.out.println("User с именем Robert добавлен в базу данных");
        userService.saveUser("Mike", "Klimson", (byte) 24);
        System.out.println("User с именем Mike добавлен в базу данных");
        userService.saveUser("Dan", "Balan", (byte) 42);
        System.out.println("User с именем Dan добавлен в базу данных");

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
