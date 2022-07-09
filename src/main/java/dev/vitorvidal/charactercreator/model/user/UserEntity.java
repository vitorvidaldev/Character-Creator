package dev.vitorvidal.charactercreator.model.user;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Document("user")
public class UserEntity {
    @NotNull
    private String username;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @MongoId(FieldType.STRING)
    private UUID userId;

    public UserEntity() {
    }

    public UserEntity(String username, String email, String password) {
        this.userId = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
