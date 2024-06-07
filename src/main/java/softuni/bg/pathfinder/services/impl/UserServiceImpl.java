package softuni.bg.pathfinder.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.pathfinder.models.Role;
import softuni.bg.pathfinder.models.User;
import softuni.bg.pathfinder.models.UserRole;
import softuni.bg.pathfinder.models.dtos.UserRegisterDto;
import softuni.bg.pathfinder.repositories.RoleRepository;
import softuni.bg.pathfinder.repositories.UserRepository;
import softuni.bg.pathfinder.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void RegisterUser(UserRegisterDto userRegisterDto) {
        if(userRepository.findUserByUsername(userRegisterDto.getUsername()).isEmpty()
        && userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            User newUser = modelMapper.map(userRegisterDto, User.class);
            newUser.getRoles().add(roleRepository.findByName(UserRole.valueOf("USER")));
            userRepository.saveAndFlush(newUser);
        }
    }
}
