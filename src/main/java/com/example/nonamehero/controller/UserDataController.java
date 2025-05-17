package com.example.nonamehero.controller;

import com.example.nonamehero.model.UserData;
import com.example.nonamehero.repository.UserDataRepository;
import com.example.nonamehero.service.GameDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserDataController {

    private final GameDataService gameDataService;

    public UserDataController(GameDataService gameDataService) {
        this.gameDataService = gameDataService;
    }

    @PostMapping("/userdata")
    public ResponseEntity<UserData> saveOrUpdate(@RequestBody UserData dto) {
        UserData saved = gameDataService.saveOrUpdateUserData(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/userid")
    public ResponseEntity<UserData> getUserDataById(@RequestParam Long id) {
        UserData userData = gameDataService.findUserDataById(id);
        if (userData != null) {
            return ResponseEntity.ok(userData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}