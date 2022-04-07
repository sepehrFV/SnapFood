package com.myexple.snapfood.service;

import com.myexple.snapfood.dao.UserDao;
import com.myexple.snapfood.common.SessionFactoryInjector;
import com.myexple.snapfood.entity.User;
import org.hibernate.Session;

import java.util.List;

public class UserService implements IUserService{

    private UserDao dao;
    private SessionFactoryInjector sf;
    private Session session;

    public UserService(){
        dao = new UserDao();
        sf = new SessionFactoryInjector();
        this.session = sf.getSession();
        dao.setSession(session);
    }


    @Override
    public void add(User u){
       session.getTransaction().begin();
       try{
           dao.insert(u);
           session.getTransaction().commit();
       }catch (Exception e){
           session.getTransaction().rollback();
           System.out.println(e.getMessage());
       }

    }

    @Override
    public User update(User updatedUser) {
        session.getTransaction().begin();
        dao.update(updatedUser);
        session.getTransaction().commit();
        return updatedUser;
    }

    @Override
    public void remove(Long id) {
        session.getTransaction().begin();

        try{
            dao.delete(id);
            session.getTransaction().commit();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public User getById(Long id) {
        session.getTransaction().begin();
        User u = dao.findById(id);
        session.getTransaction().commit();
        return u;
    }

    @Override
    public List<User> getAll() {
        List<User> userList=null;
        session.getTransaction().begin();
        userList= dao.findAll();
        session.getTransaction().commit();
        return userList;
    }
}
