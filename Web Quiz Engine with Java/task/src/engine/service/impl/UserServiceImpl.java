package engine.service.impl;

import engine.domain.User;
import engine.dto.NewUserDto;
import engine.exception.UserExistsException;
import engine.repository.UserRepository;
import engine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void registerUser(NewUserDto newUserDto) throws UserExistsException {
        if (repository.existsByUsernameIgnoreCase(newUserDto.email())) {
            throw new UserExistsException();
        }
        User user = new User()
                .setUsername(newUserDto.email())
                .setPassword(encoder.encode(newUserDto.password()));
        repository.save(user);
    }
}
