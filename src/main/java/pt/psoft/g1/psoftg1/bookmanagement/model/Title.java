package pt.psoft.g1.psoftg1.bookmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public class Title {
    private final int MAX_LENGTH = 150;
    //TODO: Confirmar os valores maximos e minimos do title
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 1, max = MAX_LENGTH)
    @Column(name="TITLE") // , length = x
    String title;

    protected Title() {}

    public Title(String title) {
        setTitle(title);
    }

    public void setTitle(String title) {

/*
        if (!StringUtilsCustom.startsOrEndsInWhiteSpace(title)) {
            throw new IllegalArgumentException("Invalid title: " + title);
        }
*/
        if(title == null)
            throw new IllegalArgumentException("Title cannot be null");
        if(title.isBlank())
            throw new IllegalArgumentException("Title cannot be blank");
        if(title.length() > MAX_LENGTH)
            throw new IllegalArgumentException("Title has a maximum of " + MAX_LENGTH + " characters");
        this.title = title.strip();
    }

    public String toString() {
        return this.title;
    }
}
