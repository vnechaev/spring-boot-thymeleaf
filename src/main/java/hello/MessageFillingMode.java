package hello;

public enum MessageFillingMode {
    FILE("file_mode"),
    TEXT("text_mode");
    ;

    MessageFillingMode(String description) {
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private String description;

}
