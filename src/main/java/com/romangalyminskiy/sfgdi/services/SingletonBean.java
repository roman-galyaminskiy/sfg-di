package com.romangalyminskiy.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("##### I'm a singleton constructor");
    }

    public String getMyScope() {
        return "singleton";
    }
}
