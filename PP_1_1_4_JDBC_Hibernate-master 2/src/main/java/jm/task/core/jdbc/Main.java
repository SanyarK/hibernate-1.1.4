package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Hellish", "Task", (byte) 10);
        userService.saveUser("Devilish", "Headache", (byte) 20);
        userService.saveUser("Sleeping", "Brain", (byte) 30);
        userService.saveUser("Good", "Night", (byte) 40);

        List<User> allUsers = userService.getAllUsers();
        for (User users : allUsers) {
            System.out.println(users);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}



