package ua.kryha.service.services;

import ua.kryha.service.forms.UserForm;
import ua.kryha.service.models.JUser;

import java.util.List;


public interface UsersService {
    void signUp(UserForm userForm);

    List<JUser> findAll();

    JUser findOne(Long userId);
}
