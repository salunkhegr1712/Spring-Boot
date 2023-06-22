package com.example.DevtoolsWeb;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootballCoach implements Coach{

    @Override
    public String workout() {
        return "run 90 min straight";
    }
}
