package com.example.sdnmarvelbasic;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterRepo characterRepo;

    public CharacterController(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    @GetMapping
    public Iterable<Character> findAllCharacters() {
        return characterRepo.findAllCharacters();
    }

    @GetMapping("/{name}")
    public Character getCharacterByName(@PathVariable String name) {
        return characterRepo.getCharacterByName(name);
    }

    @PostMapping
    public Character createCharacter(@RequestBody Character character){
        return characterRepo.save(character);
    }

    @PutMapping
    public Character updateCharacter(@RequestBody Character character){
        return characterRepo.save(character);
    }

    @DeleteMapping
    public Boolean deleteCharacter(@RequestBody Character character){
        characterRepo.delete(character);
        return true;
    }
}
