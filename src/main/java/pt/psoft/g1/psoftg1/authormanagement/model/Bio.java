package pt.psoft.g1.psoftg1.authormanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pt.psoft.g1.psoftg1.shared.model.StringUtilsCustom;

@Embeddable
public class Bio {
    private final int MAX_LENGTH = 4096;

    @Column(nullable = false, length = MAX_LENGTH)
    @NotNull
    @Size(min = 1, max = MAX_LENGTH)
    private String bio;

    public Bio(String bio) {
        setBio(bio);
    }

    protected Bio() {
    }

    public void setBio(String bio) {
        if(bio == null)
            throw new IllegalArgumentException("Bio cannot be null");
        if(bio.isBlank())
            throw new IllegalArgumentException("Bio cannot be blank");
        if(bio.length() > MAX_LENGTH)
            throw new IllegalArgumentException("Bio has a maximum of 4096 characters");
        this.bio = StringUtilsCustom.sanitizeHtml(bio);
    }

    @Override
    public String toString() {
        return bio;
    }
}

