package lt.techin.books_demo.mapper;

import lt.techin.books_demo.controllers.dto.UserDto;
import lt.techin.books_demo.model.User;

public interface UserMapper {

    UserDto toUserDto(User user);
}