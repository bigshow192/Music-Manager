package com.example.musicmanager.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.lang.reflect.Constructor;
@Getter
@Setter
@Table(name="Music")
@NoArgsConstructor
@Component
@Data
@ToString
@Entity
public class Music {
    @Id
    @Column(name="name")
    private String name;
    @Column(name="genre")
    private String genre;
    @Column(name="filename")
    private String filename;
    public Music(String name,String genre,String filename)
    {
        this.filename=filename;
        this.name=name;
        this.genre=genre;
    }
    public Music(long id,String name,String genre,String filename)
    {

        this.filename=filename;
        this.name=name;
        this.genre=genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
