package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private static final Connection conn = Util.getInstance().getConnection();



    public void createUsersTable() {
        try {
            Statement statement = conn.createStatement();

            try {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), last_name VARCHAR(255), age INT)");
            } catch (Throwable var5) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var4) {
                        var5.addSuppressed(var4);
                    }
                }

                throw var5;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try {
            Statement statement = conn.createStatement();

            try {
                statement.executeUpdate("DROP TABLE IF EXISTS users");
            } catch (Throwable var5) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var4) {
                        var5.addSuppressed(var4);
                    }
                }

                throw var5;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)");

            try {
                pstm.setString(1, name);
                pstm.setString(2, lastName);
                pstm.setByte(3, age);
                pstm.executeUpdate();
            } catch (Throwable var8) {
                if (pstm != null) {
                    try {
                        pstm.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (pstm != null) {
                pstm.close();
            }
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        try {
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM users WHERE id = ?");

            try {
                pstm.setLong(1, id);
                pstm.executeUpdate();
            } catch (Throwable var7) {
                if (pstm != null) {
                    try {
                        pstm.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }

            if (pstm != null) {
                pstm.close();
            }
        } catch (SQLException var8) {
            var8.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        ArrayList users = new ArrayList();

        try {
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM users");

            try {
                while(resultSet.next()) {
                    User user = new User(resultSet.getString("name"), resultSet.getString("last_name"), resultSet.getByte("age"));
                    user.setId(resultSet.getLong("id"));
                    users.add(user);
                }
            } catch (Throwable var6) {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (Throwable var5) {
                        var6.addSuppressed(var5);
                    }
                }

                throw var6;
            }

            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return users;
    }

    public void cleanUsersTable() {
        try {
            Statement statement = conn.createStatement();

            try {
                statement.executeUpdate("TRUNCATE TABLE users");
            } catch (Throwable var5) {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (Throwable var4) {
                        var5.addSuppressed(var4);
                    }
                }

                throw var5;
            }

            if (statement != null) {
                statement.close();
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

    }
}
