package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.UserService;
import dev.vitorvidal.charactercreator.model.user.SignupVO;
import dev.vitorvidal.charactercreator.model.user.UserVO;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/rest/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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
    public ResponseEntity<UserVO> updateUserData(@PathVariable(value = "userId") UUID userId) {
        UserVO userVO = userService.updateUserData(userId);
        return ResponseEntity.ok().body(userVO);
    }

    @PutMapping("/password/{userId}")
    public ResponseEntity<UserVO> updatePassword(@PathVariable(value = "userId") UUID userId) {
        UserVO userVO = userService.updatePassword(userId);
        return ResponseEntity.ok().body(userVO);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "userId") UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
