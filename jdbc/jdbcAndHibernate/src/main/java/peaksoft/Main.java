package peaksoft;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJdbcImpl users = new UserDaoJdbcImpl();
//        users.createUsersTable();
//        users.dropUsersTable();
//        users.saveUser("Aidana", "Aidarova", (byte) 17);
//        users.saveUser("Samagan", "Arzykulov", (byte) 20);
//        users.saveUser("Saikal", "Sher", (byte) 18);
//        users.saveUser("Aida", "Ismanova", (byte) 22);

        users.removeUserById(1);
        users.getAllUsers().forEach(System.out::println);








    }
}
