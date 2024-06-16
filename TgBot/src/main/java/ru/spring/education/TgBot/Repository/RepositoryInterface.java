package ru.spring.education.TgBot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.education.TgBot.Model.JokeModel;


public interface RepositoryInterface extends JpaRepository<JokeModel, Long> {
}
