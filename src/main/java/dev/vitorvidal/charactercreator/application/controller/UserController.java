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
        UserVO userVO = userService.getUserById(id);
        return ResponseEntity.ok().body(userVO);
    }

    @PutMapping("/data/{id}")
    public ResponseEntity<UserVO> updateUserData(@PathVariable ObjectId id) {
        UserVO userVO = userService.updateUserData(id);
        return ResponseEntity.ok().body(userVO);
    }

    @PutMapping("/password/{id}")
    public ResponseEntity<UserVO> updatePassword(@PathVariable ObjectId id) {
        UserVO userVO = userService.updatePassword(id);
        return ResponseEntity.ok().body(userVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ObjectId id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
