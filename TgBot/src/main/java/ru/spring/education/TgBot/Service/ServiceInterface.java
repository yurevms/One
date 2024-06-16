package ru.spring.education.TgBot.Service;

import ru.spring.education.TgBot.Model.JokeModel;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {
    List<JokeModel> getJokes();

    Optional<JokeModel> getJokeByid(Long id);

    JokeModel postJoke(JokeModel jokeModel);

    Optional<JokeModel> putJoke(Long id, JokeModel jokeModel);

    void deleteJoke(Long id);
}
