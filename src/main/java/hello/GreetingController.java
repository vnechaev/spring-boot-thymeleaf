package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @Autowired
    WorkService workService;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            @RequestParam(name="inputText", required=false, defaultValue="file_mode") String inputText,
            Model model
    ) {
        model.addAttribute("name", name);
        model.addAttribute("inputText", inputText);
        model.addAttribute("fillingModeEnum", MessageEnum.values());
        return "greeting";
    }


    @PostMapping(value = "/greeting", params = "save")
    public String getSubmit(MessageModeWrapper messageModeWrapper){
        workService.setMessage(messageModeWrapper.getMode());
        return String.format("redirect:/greeting?inputText=%s", messageModeWrapper.getMode());
    }

    @PostMapping(value = "/greeting", params = "send")
    public String doJob(){
        workService.doTask();
        return "redirect:/greeting";
    }

}
