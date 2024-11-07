package engine.repository;

import engine.domain.QuizCompletion;
import engine.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizCompletionRepository extends JpaRepository<QuizCompletion, Long> {
    Page<QuizCompletion> findAllByUserOrderByCompletionTimeDesc(Pageable pageable, User user);
}
