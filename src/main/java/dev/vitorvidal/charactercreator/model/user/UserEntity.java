package dev.vitorvidal.charactercreator.model.user;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Document("user")
public class UserEntity {
    @NotNull
    private final String username;
    @NotNull
    @Email
    private final String email;
    @NotNull
    private final String password;
    private ObjectId id;

    public UserEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
