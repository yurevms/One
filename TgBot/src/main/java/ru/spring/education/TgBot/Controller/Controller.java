package ru.spring.education.TgBot.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spring.education.TgBot.Model.JokeModel;
import ru.spring.education.TgBot.Service.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jokes")
public class Controller {

    private final Service service;

    @GetMapping
    ResponseEntity<List<JokeModel>> getJokes() {
        return ResponseEntity.ok(service.getJokes());
    }

    @GetMapping("/{id}")
    ResponseEntity<JokeModel> getJokeById(@PathVariable Long id) {
        Optional<JokeModel> jokeModelOptional = service.getJokeByid(id);
        return jokeModelOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<Void> postJoke(@RequestBody JokeModel jokeModel){
        service.postJoke(jokeModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteJoke(@PathVariable Long id){
        Optional<JokeModel> jokeModelOptional = service.getJokeByid(id);
        if(jokeModelOptional.isPresent()){
            service.deleteJoke(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> putJoke(@PathVariable Long id, @RequestBody JokeModel jokeModel){
        Optional<JokeModel> jokeModelOptional = service.getJokeByid(id);
        if(jokeModelOptional.isPresent()){
            service.putJoke(id, jokeModel);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
