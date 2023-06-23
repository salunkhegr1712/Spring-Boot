package com.example.DevtoolsWeb;

import org.springframework.stereotype.Component;

//this is candidate for injection so add @component
@Component
public class CricketCoach  implements Coach{

    @Override
    public String workout() {
        return "from cricCoach : do workout for 100 min per day per year";
    }
}
