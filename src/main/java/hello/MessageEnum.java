package hello;

public enum MessageEnum {
    FILE("file_mode"),
    TEXT("text_mode");
    ;

    MessageEnum(String description) {
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
