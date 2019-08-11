package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    String transportString = "notInitialized";

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
        model.addAttribute("fillingModeEnum", MessageFillingMode.values());
        return "greeting";
    }


    @PostMapping(value = "/greeting", params = "save")
    public String getSubmit(MessageMode messageMode, BindingResult bindingResult, Model model){
//        if (bindingResult.hasErrors()) {
//            return "/greeting";
//        }
//        System.out.println(bindingResult.hasErrors());
//        System.out.println(messageMode.getMode());
        transportString = messageMode.getMode();
        workService.setMessage(transportString);

        return String.format("redirect:/greeting?inputText=%s", transportString);
    }

    @PostMapping(value = "/greeting", params = "send")
    public String doJob(){
        workService.doTask();
        return "redirect:/greeting";
    }

}
