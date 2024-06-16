package ru.spring.education.TgBot.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "jokes")
@Table(name = "jokes")
public class JokeModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "joke")
    private String joke;

    @Column(name = "createdTime")
    private LocalDateTime createdTime;

    @Column(name = "updatedTime")
    private LocalDateTime updatedTime;
}
