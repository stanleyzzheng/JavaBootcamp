package stanford.guided_lab_309_5.SP7;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
class RequestParamController {
    @RequestMapping("/request1")
    @ResponseBody
    public String handler(@RequestParam(name = "name") String name) {
        return "URL paramater <br> " + "name =" + name;
    }

    @RequestMapping("/request2")
    @ResponseBody
    public String handler(@RequestParam String firstName, @RequestParam String lastName) {
        return "URL paramaters - <br>" + " firstName = " + firstName + " <br>" + " lastName = " + lastName;
    }

    @RequestMapping("/request3")
    @ResponseBody
    public String handler(@RequestParam("name") String name, @RequestParam("age") int age,
                          @RequestParam("amount") double amount, @RequestParam("active") boolean active) {
        return "URL paramater - <br>" + " name = " + name + " <br>" + " age = " + age + " <br>" + " amount = " + amount + " <br"
                + ">" + " active = " + active;
    }

    @RequestMapping("/request4")
    @ResponseBody
    public String handler(@RequestParam Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        builder.append("URL parameters - <br>");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.append(entry.getKey() + " = " + entry.getValue() + "<br>");

        }
        return builder.toString();
    }

    @RequestMapping("/request5")
    @ResponseBody
    public String handler(@RequestParam("firstName") String firstName,
                          @RequestParam(name = "middleName", required = false) String middleName,
                          @RequestParam("lastName") String lastName) {
        return "URL parameters - <br>" + " firstName = " + firstName + " <br>" + " middleName = " + middleName + " <br>" + " " +
                "lastName = " + lastName;
    }

    @RequestMapping("/request6")
    @ResponseBody
    public String handler(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") LocalDate date,
                          @DateTimeFormat(pattern = "HH:mm:ss") @RequestParam("time") LocalTime time) {
        return "URL parameters - <br>" + " date = " + date + " <br>" + " time = " + time;
    }
    @RequestMapping("/request7")
    @ResponseBody
    public String handler(@RequestParam("country") String[] country,
                          @RequestParam("city") List<String> city) {

        return "URL parameters - <br>"
                + " country = " + Arrays.asList(country) + " <br>"
                + " city = " + city;
    }
    @RequestMapping("/request8")
    @ResponseBody
    public String handler(@RequestParam(name = "code", defaultValue = "10") int code) {
        return "URL parameters - <br>" + " code = " + code;
    }

}
