package telran.java58.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NewCommentDto {
    @NotBlank(message = "message is required")
    @Size(min = 10, message = "message should be at least 10 symbols")
    private String message;
}
