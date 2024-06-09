package softuni.bg.pathfinder.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.bg.pathfinder.models.Role;
import softuni.bg.pathfinder.models.User;
import softuni.bg.pathfinder.models.UserRole;
import softuni.bg.pathfinder.models.dtos.UserLoginDto;
import softuni.bg.pathfinder.models.dtos.UserRegisterDto;
import softuni.bg.pathfinder.repositories.RoleRepository;
import softuni.bg.pathfinder.repositories.UserRepository;
import softuni.bg.pathfinder.services.CurrentUser;
import softuni.bg.pathfinder.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void RegisterUser(UserRegisterDto userRegisterDto) {
        if(userRepository.findUserByUsername(userRegisterDto.getUsername()).isEmpty()
        && userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            User newUser = modelMapper.map(userRegisterDto, User.class);
            newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
            newUser.getRoles().add(roleRepository.findByName(UserRole.valueOf("USER")));
            userRepository.saveAndFlush(newUser);
        }
    }

    @Override
    public boolean login(UserLoginDto userLoginDto) {

        Optional<User> optionalUser = userRepository.findUserByUsername(userLoginDto.getUsername());
        if(optionalUser.isEmpty()){
            return false;
        }
        User user = optionalUser.get();
        String rawPassword = user.getPassword();
        boolean matches = passwordEncoder.matches(userLoginDto.getPassword(),rawPassword);
        if(matches){
            currentUser.setFullName(user.getFullName());
            currentUser.setLoggedIn(true);
        } else {
            currentUser.reset();
        }
        return matches;
    }
}
