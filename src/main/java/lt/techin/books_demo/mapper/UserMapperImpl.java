package lt.techin.books_demo.mapper;

import lt.techin.books_demo.model.User;
import org.springframework.stereotype.Service;
import lt.techin.books_demo.controllers.dto.UserDto;

import java.util.List;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getRole());
    }

}
