package com.princechouhan.ormqueryhandson.repository;

import com.princechouhan.ormqueryhandson.model.Attempt;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("SELECT DISTINCT a FROM Attempt a join fetch a.user u join fetch a.attemptQuestionList aq join fetch aq.question q join fetch aq.attemptOptionList ao join fetch ao.option o WHERE u.id = :userId AND a.id = :attemptId")
    Optional<Attempt> getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
