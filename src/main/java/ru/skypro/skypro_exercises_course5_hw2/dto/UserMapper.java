package ru.skypro.skypro_exercises_course5_hw2.dto;


import org.springframework.stereotype.Component;
import ru.skypro.skypro_exercises_course5_hw2.dto.UserDto;
import ru.skypro.skypro_exercises_course5_hw2.entity.User;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }
}
