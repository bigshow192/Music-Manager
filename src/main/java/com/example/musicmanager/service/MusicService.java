package com.example.musicmanager.service;

import com.example.musicmanager.models.Music;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MusicService {
    public List<Music> getListMusic();

   void addMusic(Music music);


}
