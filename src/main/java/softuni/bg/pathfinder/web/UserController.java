package softuni.bg.pathfinder.web;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.bg.pathfinder.models.dtos.UserLoginDto;
import softuni.bg.pathfinder.models.dtos.UserRegisterDto;
import softuni.bg.pathfinder.services.UserService;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String viewRegister(Model model){
        if(!model.containsAttribute("userRegister")) {
            model.addAttribute("userRegister",new UserRegisterDto());
        }
        return "register";
    }

    @PostMapping("/users/register")
    public String doRegister(@Valid UserRegisterDto userRegisterDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors() || !userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            redirectAttributes = redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegister", bindingResult);
            redirectAttributes.addFlashAttribute("userRegister",userRegisterDto);

            return "redirect:/users/register";
        }

        userService.RegisterUser(userRegisterDto);

        return "login";
    }

    @GetMapping("/users/login")
    public String viewLogin(){
        return "login";
    }

    @PostMapping("/users/login")
    public String loginUser(UserLoginDto userLoginDto){

        if(userService.login(userLoginDto)){
            return "redirect:/";
        }
        return "login";

    }
}
