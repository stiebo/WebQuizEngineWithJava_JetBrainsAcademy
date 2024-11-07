package engine.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public record NewUserDto(
        @NotBlank
        @Pattern(regexp = "\\w+(\\.\\w+)?@\\w+\\.\\w{2,3}")
        String email,
        @NotBlank
        @Size(min = 5)
        String password) { }
