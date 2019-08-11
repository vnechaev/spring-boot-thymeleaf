package hello;

import org.springframework.stereotype.Service;

@Service
public class WorkService {
    private String message;

    public void doTask(){
        System.out.println(String.format("Message \"%s\" was received\n Some work is doing", message));
    }
    public WorkService() {
    }

    public WorkService(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
