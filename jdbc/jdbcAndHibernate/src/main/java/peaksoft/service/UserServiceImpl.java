package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;
import peaksoft.dao.UserDaoJdbcImpl;
import java.util.List;

public class UserServiceImpl implements UserService {
   private UserDao userDao = new UserDaoHibernateImpl();


    public void createUsersTable() {
        userDao.createUsersTable();

    }

    public void dropUsersTable() {
        userDao.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        this.userDao.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);

    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }


}
