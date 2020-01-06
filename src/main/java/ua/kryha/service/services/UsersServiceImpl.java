package ua.kryha.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.kryha.service.forms.UserForm;
import ua.kryha.service.models.JUser;
import ua.kryha.service.models.Role;
import ua.kryha.service.models.State;
import ua.kryha.service.repositories.UsersRepository;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        JUser JUser = ua.kryha.service.models.JUser.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        usersRepository.save(JUser);
    }

    @Override
    public List<JUser> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public JUser findOne(Long userId) {
        return usersRepository.findOne(userId);
    }
}
