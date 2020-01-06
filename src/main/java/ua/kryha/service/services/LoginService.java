package ua.kryha.service.services;

import ua.kryha.service.forms.LoginForm;
import ua.kryha.service.transfer.TokenDto;

/**
 * 25.04.2018
 * LoginService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface LoginService {
    TokenDto login(LoginForm loginForm);
}
