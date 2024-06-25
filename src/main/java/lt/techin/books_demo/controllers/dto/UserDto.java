package lt.techin.books_demo.controllers.dto;

import java.time.ZonedDateTime;
import java.util.List;

public record UserDto(Long id, String username, String name, String email, String role) {

    public record OrderDto(String id, String description, ZonedDateTime createdAt) {
    }
}