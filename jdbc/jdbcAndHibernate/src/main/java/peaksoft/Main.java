package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoHibernateImpl usersH = new UserDaoHibernateImpl();
//        usersH.createUsersTable();
        usersH.dropUsersTable();
        usersH.saveUser("Azamat", "Nurlanov", (byte) 18);
        usersH.saveUser("ЯЯЯЯЯЯ", "ТЫЫЫЫЫЫ", (byte) 18);
////        usersH.removeUserById(1);
        usersH.getAllUsers().forEach(System.out::println);



        /* usersH.cleanUsersTable(); */

    }
}
