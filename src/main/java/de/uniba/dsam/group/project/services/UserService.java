package de.uniba.dsam.group.project.services;

import de.uniba.dsam.group.project.models.User;

import java.util.List;

public interface UserService  {
    List<User> getAllUsers();

    User getUserById(Long userId);

    User getUserByUserName(String userName);

    void createUser(User user);

    Boolean deleteUserById(Long userId);


    Boolean updateUser(User user, Long userId);


}

