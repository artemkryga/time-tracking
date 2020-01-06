package ua.kryha.service.services;

import org.apache.commons.lang.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.kryha.service.forms.LoginForm;
import ua.kryha.service.models.JUser;
import ua.kryha.service.models.Token;
import ua.kryha.service.repositories.TokensRepository;
import ua.kryha.service.repositories.UsersRepository;
import ua.kryha.service.transfer.TokenDto;

import java.util.Optional;


@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<JUser> userCandidate = usersRepository.findOneByLogin(loginForm.getLogin());

        if (userCandidate.isPresent()) {
            JUser JUser = userCandidate.get();

            if (passwordEncoder.matches(loginForm.getPassword(), JUser.getHashPassword())) {
                Token token = Token.builder()
                        .jUser(JUser)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();

                tokensRepository.save(token);
                return TokenDto.from(token);
            }
        } throw new IllegalArgumentException("User not found");
    }
}
