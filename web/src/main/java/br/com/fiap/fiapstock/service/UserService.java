package br.com.fiap.fiapstock.service;

import br.com.fiap.fiapstock.dto.AuthDTO;
import br.com.fiap.fiapstock.dto.JwtDTO;
import br.com.fiap.fiapstock.dto.UserCreateDTO;
import br.com.fiap.fiapstock.dto.UserDTO;

public interface UserService {

    UserDTO create(UserCreateDTO userCreateDTO);
    JwtDTO login(AuthDTO authDTO);

}
