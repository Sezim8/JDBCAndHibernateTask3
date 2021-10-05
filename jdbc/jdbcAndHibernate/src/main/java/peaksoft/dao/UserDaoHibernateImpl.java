package peaksoft.dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("create  table  users ( " +
                    " id serial primary key ," +
                    " name varchar not null, " +
                    " last_name varchar not null ," +
                    " age smallint  not null )").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Создана таблица");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("drop table if exists users").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Таблица удалена!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
            session.close();
            System.out.println("Добавлен пользователь!");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery(String.format("delete from users where id = %d", id)).executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Пользователь удален!");

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> fromUsers = session.createQuery("from users").getResultList();
        session.getTransaction().commit();
        session.close();
        return fromUsers;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("truncate table users").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Удалены пользователи из таблицы...");

    }
}
