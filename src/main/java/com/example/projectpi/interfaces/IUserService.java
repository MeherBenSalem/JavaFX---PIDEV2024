package com.example.projectpi.interfaces;

import com.example.projectpi.entites.User;

import java.util.List;

public interface IUserService {
    int Create(User user);
    List<User> Read();
    int Update(int id,User user);
    int Delete(int id);

}
