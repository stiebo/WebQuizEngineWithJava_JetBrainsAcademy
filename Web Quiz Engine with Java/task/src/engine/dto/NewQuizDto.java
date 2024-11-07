package engine.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record NewQuizDto(
        @NotBlank
        String title,
        @NotBlank
        String text,
        @NotNull
        @Size(min=2)
        String[] options,
        Integer[] answer) {
}
