package com.example.sdnmarvelbasic;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comics")
public class ComicController {
    private final ComicRepo comicRepo;

    public ComicController(ComicRepo comicRepo){
        this.comicRepo = comicRepo;
    }

    @GetMapping
    public Iterable<ComicIssue> findAllComics() {
        return comicRepo.findAllComics();
    }

    @GetMapping("/{name}")
    public ComicIssue getComicIssueByName(@PathVariable String name) {
        return comicRepo.getComicIssueByName(name);
    }

    @PostMapping
    public ComicIssue createTriples(@RequestBody ComicIssue comicIssue){
        return comicRepo.save(comicIssue);
    }

    @PutMapping
    public ComicIssue updateTriples(@RequestBody ComicIssue comicIssue){
        return comicRepo.save(comicIssue);
    }

    @DeleteMapping
    public boolean deleteTriples(@RequestBody ComicIssue comicIssue){
        comicRepo.delete(comicIssue);
        return true;
    }
}
