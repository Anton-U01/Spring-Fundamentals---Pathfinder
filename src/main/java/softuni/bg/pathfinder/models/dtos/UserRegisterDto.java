package softuni.bg.pathfinder.models.dtos;


import jakarta.validation.constraints.*;

public class UserRegisterDto {
    @NotEmpty
    @NotNull
    @Size(min = 2)
    private String username;
    @NotEmpty
    @Size(min = 2)
    private String fullName;
    @Pattern(regexp = "^[^@]+@[^@]+$")
    private String email;
    @Positive
    private int age;
    @NotEmpty
    @Size(min = 2)
    private String password;
    @NotEmpty
    @Size(min = 2)
    private String confirmPassword;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
