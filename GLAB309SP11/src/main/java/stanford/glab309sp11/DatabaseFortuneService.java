package stanford.glab309sp11;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneServices {

    @Override
    public String getFortune() {
        // TODO Auto-generated method stub
        return "Database connection";
    }
}