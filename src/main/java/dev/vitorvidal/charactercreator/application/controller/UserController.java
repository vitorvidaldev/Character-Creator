package dev.vitorvidal.charactercreator.application.controller;

import dev.vitorvidal.charactercreator.application.service.UserService;
import dev.vitorvidal.charactercreator.model.user.SignupVO;
import dev.vitorvidal.charactercreator.model.user.UserVO;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserVO>> getAllUsers() {
        List<UserVO> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<UserVO> signup(@RequestBody @Valid SignupVO signupVO) {
        UserVO userVO = userService.signup(signupVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userVO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserVO> getUserById(@PathVariable ObjectId id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserVO> updateUserData(@PathVariable ObjectId id) {
        return userService.updateUserData(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserVO> updatePassword(@PathVariable ObjectId id) {
        return userService.updatePassword(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ObjectId id) {
        return userService.deleteUser(id);
    }
}
