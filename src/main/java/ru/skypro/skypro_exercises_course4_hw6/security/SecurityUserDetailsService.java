package ru.skypro.skypro_exercises_course4_hw6.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skypro.skypro_exercises_course4_hw6.dto.UserDto;
import ru.skypro.skypro_exercises_course4_hw6.repository.UserRepository;
import ru.skypro.skypro_exercises_course4_hw6.service.UserMapper;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SecurityUserPrincipal userDetails;

    public SecurityUserDetailsService(UserRepository userRepository, UserMapper userMapper, SecurityUserPrincipal userDetails) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userDetails = userDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDto userDto = userRepository.findByLogin(username)
                .map(userMapper::toDto)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User name %s  not found".formatted(username))
                );
        userDetails.setUserDto(userDto);
        return userDetails;
    }
}