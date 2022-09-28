package com.example.musicmanager.controller;

import com.example.musicmanager.exception.ResourceNotFoundException;
import com.example.musicmanager.models.Music;
import com.example.musicmanager.repository.MusicRepository;
import com.example.musicmanager.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class MusicController {
    @Autowired
    private MusicRepository musicRepo;
    @Autowired
    private MusicService musicService;

    public void setMusicService(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/")
    public String showMusic(Model model){
        List<Music> m= musicRepo.findAll();
        model.addAttribute("listm",m);
        return "index";

    }

    @PostMapping("/new_music")
    public String saveData(@ModelAttribute @RequestBody Music music, HttpServletRequest request) {
        String name=request.getParameter("name");
        String genre=request.getParameter("genre");
        String filename=request.getParameter("filename");
        music= new Music(name,genre,filename);
        Music dest=musicRepo.save(music);
        return "redirect:/";
    }
    @PostMapping("edit_music")
    public String editData( @ModelAttribute @RequestBody Music music, HttpServletRequest request)
    {
        String name=request.getParameter("name");
        String genre=request.getParameter("genre");
        String filename=request.getParameter("filename");
        System.out.println(name);
        Music musicUpdate =musicRepo.findById(name).orElseThrow(()-> new ResourceNotFoundException("not found"));
        musicUpdate.setName(name);
        musicUpdate.setGenre(genre);
        musicUpdate.setFilename(filename);
        musicRepo.save(musicUpdate);
        return "redirect:/";
    }
    @PostMapping("/delete_music")
    public String deleteData(@RequestBody @ModelAttribute Music music,HttpServletRequest request)
    {
        String name=request.getParameter("name");
        musicRepo.deleteById(name);
        return "redirect:/";
    }
    @PostMapping("/deleteall_music")
    public String deleteallData(@RequestBody @ModelAttribute Music music,HttpServletRequest request)
    {
        musicRepo.deleteAll();
        return "redirect:/";
    }
}