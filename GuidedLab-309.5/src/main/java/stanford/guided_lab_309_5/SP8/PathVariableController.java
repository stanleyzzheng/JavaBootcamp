package stanford.guided_lab_309_5.SP8;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
class PathVariableController {
    @GetMapping("/request1/{name}")
    @ResponseBody
    public String handler(@PathVariable(name = "name") String name) {
        return "URL parameter name: " + name;
    }

    @GetMapping("/request2/{firstName}/{lastName}")
    @ResponseBody
    public String handler(@PathVariable String firstName, @PathVariable String lastName) {
        return "URL parameters - <br>" + " firstName = " + firstName + " <br>" + " lastName = " + lastName;
    }

    @GetMapping("/request3/{name}/{age}/{salary}/{active}")
    @ResponseBody
    public String handler(@PathVariable("name") String name, @PathVariable("age") int age,
                          @PathVariable("salary") double salary, @PathVariable("active") boolean active) {
        return "URL parameters - <br>" + " name = " + name + " <br>" + " age = " + age + " <br>" + " salary = " + salary + " " +
                "<br>" + " active = " + active;
    }
    @GetMapping("/request4/{name}/{age}/{address}/{city}/{country}")
    @ResponseBody
    public String handler(@PathVariable Map<String,String> params){
        StringBuilder builder = new StringBuilder();
        builder.append("URL paramters - <br>");
        for (Map.Entry<String,String> entry : params.entrySet()){
            builder.append(entry.getKey() + " = " + entry.getValue() + "<br>");
        }
        return builder.toString();
    }

    @GetMapping("/request5/{date}/{time}")
    @ResponseBody
    public String handler(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("date") LocalDate date,
                          @DateTimeFormat(pattern = "HH:mm:ss") @PathVariable("time") LocalTime time) {
        return "URL parameters - <br>"
                + " date = " + date + " <br>"
                + " time = " + time;
    }

    @GetMapping("/request6/{country}/{city}")
    @ResponseBody
    public String handler(@PathVariable("country") String[] country, @PathVariable("city") List<String> city){
        return "URL parameters - <br>"
                + " country = " + Arrays.asList(country) + " <br>"
                + " city = " + city;
    }
}
