package engine.dto;

import java.time.LocalDateTime;

public record QuizCompletionDto(
        Long id,
        LocalDateTime completedAt) { }
