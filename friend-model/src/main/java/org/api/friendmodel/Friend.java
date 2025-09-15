package org.api.friendmodel;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "friends",schema = "public")
public class Friend {
    @Id
    private Integer id;
    @NotEmpty(message = "name обязательное поле и не может быть пустое или null")
    private String name;
    @NotNull(message = "age обязательное поле и не может быть null")
    private Integer age;
    @NotNull(message = "priority обязательное поле и не может быть null")
    private Integer priority;
    @NotEmpty(message = "hobby обязательное поле и не может быть пустое или null")
    private String hobby;
}

