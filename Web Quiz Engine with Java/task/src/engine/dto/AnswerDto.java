package engine.dto;

import javax.validation.constraints.NotNull;

public record AnswerDto(
        @NotNull
        Integer[] answer) {
}
