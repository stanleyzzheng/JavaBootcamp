package stanford.guided_lab_309_5.SP9;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoController {
    @GetMapping("/get-info")
    public String getStringMessage(){
        return "Hi ! You will be able to monitor the health of the application !!" ;

    }
}
