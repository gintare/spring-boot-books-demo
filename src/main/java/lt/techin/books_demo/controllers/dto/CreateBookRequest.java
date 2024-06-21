package lt.techin.books_demo.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRequest {
    @NotBlank
    @NonNull
    private String title;
    @NotBlank
    @NonNull
    private String description;
    @NotBlank
    private String ISBN;
    @NotBlank
    private String photo;
    private int pagesCount;

}
