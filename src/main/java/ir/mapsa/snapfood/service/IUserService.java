package ir.mapsa.snapfood.service;


import ir.mapsa.snapfood.entity.User;

import java.util.List;

public interface IUserService {

    void add(User u) throws Exception;

    User update(User updatedUser);

    void remove(Long id);

    User getById(Long id);

    List<User> getAll();


}
