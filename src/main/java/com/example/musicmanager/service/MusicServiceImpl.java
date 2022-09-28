package com.example.musicmanager.service;

import com.example.musicmanager.models.Music;
import com.example.musicmanager.repository.MusicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService{
    private MusicRepository musicRepository;
    private static ArrayList<Music> music =new ArrayList<Music>();
   static {
       music.add(new Music("2","2","3"));
   }
    @Override
    public List<Music> getListMusic() {
        return music;
    }
    @Transactional
    public void addMusic(Music music)
    {
        musicRepository.saveAndFlush(music);
    }
}
