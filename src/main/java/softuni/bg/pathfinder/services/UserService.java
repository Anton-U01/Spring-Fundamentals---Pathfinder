package softuni.bg.pathfinder.services;

import softuni.bg.pathfinder.models.dtos.UserLoginDto;
import softuni.bg.pathfinder.models.dtos.UserRegisterDto;

public interface UserService {
    void RegisterUser(UserRegisterDto userRegisterDto);

    boolean login(UserLoginDto userLoginDto);
}
