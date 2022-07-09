package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.UserService;
import dev.vitorvidal.charactercreator.model.user.SignupVO;
import dev.vitorvidal.charactercreator.model.user.UpdateUserDataVO;
import dev.vitorvidal.charactercreator.model.user.UpdateUserPasswordVO;
import dev.vitorvidal.charactercreator.model.user.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/rest/v1/users")
public record UserController(UserService userService) {
    @PostMapping
    public ResponseEntity<UserVO> signup(@RequestBody @Valid SignupVO signupVO) {
        UserVO userVO = userService.signup(signupVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userVO);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserVO> getUserById(@PathVariable(value = "userId") UUID userId) {
        UserVO userVO = userService.getUserById(userId);
        return ResponseEntity.ok().body(userVO);
    }

    @PutMapping("/data/{userId}")
    public ResponseEntity<UserVO> updateUserData(
            @PathVariable(value = "userId") UUID userId,
            @RequestBody @Valid UpdateUserDataVO updateUserDataVO) {
        UserVO userVO = userService.updateUserData(userId, updateUserDataVO);
        return ResponseEntity.ok().body(userVO);
    }

    @PutMapping("/password/{userId}")
    public ResponseEntity<UserVO> updatePassword(
            @PathVariable(value = "userId") UUID userId,
            @RequestBody @Valid UpdateUserPasswordVO updateUserPasswordVO) {
        UserVO userVO = userService.updatePassword(userId, updateUserPasswordVO);
        return ResponseEntity.ok().body(userVO);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "userId") UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
