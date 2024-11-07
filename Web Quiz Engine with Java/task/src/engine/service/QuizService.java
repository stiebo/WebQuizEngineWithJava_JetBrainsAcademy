package engine.service;

import engine.domain.Quiz;
import engine.domain.QuizCompletion;
import engine.domain.User;
import engine.dto.AnswerDto;
import engine.dto.ResultDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuizService {
    Quiz addQuiz(Quiz quiz);
    Quiz getQuiz(Long id);
    Page<Quiz> findAll(Pageable pageable);
    ResultDto solveQuiz(Long id, AnswerDto answerDto, User user);
    void deleteQuiz(Long id, User requester);
    Page<QuizCompletion> findAllCompleted(Pageable pageable, User user);
}
