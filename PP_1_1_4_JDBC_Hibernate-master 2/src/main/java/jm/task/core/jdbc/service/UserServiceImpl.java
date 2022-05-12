package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.Iterator;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();

    public UserServiceImpl() {
    }

    public void createUsersTable() {
        this.userDao.createUsersTable();
    }

    public void dropUsersTable() {
        this.userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        this.userDao.saveUser(name, lastName, age);
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        this.userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> users = this.userDao.getAllUsers();
        Iterator var2 = users.iterator();

        while(var2.hasNext()) {
            User user = (User)var2.next();
            System.out.println(user);
        }

        return users;
    }

    public void cleanUsersTable() {
        this.userDao.cleanUsersTable();
    }
}
