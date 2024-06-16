package ru.spring.education.TgBot.Service;

import lombok.RequiredArgsConstructor;
import ru.spring.education.TgBot.Model.JokeModel;
import ru.spring.education.TgBot.Repository.RepositoryInterface;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service implements ServiceInterface{

    private final RepositoryInterface repository;

    @Override
    public List<JokeModel> getJokes() {
        return repository.findAll();
    }

    @Override
    public Optional<JokeModel> getJokeByid(Long id) {
        return repository.findById(id);
    }

    @Override
    public JokeModel postJoke(JokeModel jokeModel) {
        jokeModel.setCreatedTime(LocalDateTime.now());
        jokeModel.setUpdatedTime(null);
        repository.save(jokeModel);
        return jokeModel;
    }

    @Override
    public Optional<JokeModel> putJoke(Long id, JokeModel jokeModel) {
        Optional<JokeModel> savedData = repository.findById(id);
        JokeModel modJoke = savedData.get();
        modJoke.setJoke(jokeModel.getJoke());
        modJoke.setUpdatedTime(LocalDateTime.now());
        repository.save(modJoke);
        return savedData;
    }

    @Override
    public void deleteJoke(Long id) {
        repository.deleteById(id);
    }
}
