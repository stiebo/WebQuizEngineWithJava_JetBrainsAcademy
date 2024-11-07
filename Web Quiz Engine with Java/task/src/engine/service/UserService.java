package engine.service;

import engine.domain.User;
import engine.dto.NewUserDto;

public interface UserService {
    void registerUser(NewUserDto newUserDto);
}
