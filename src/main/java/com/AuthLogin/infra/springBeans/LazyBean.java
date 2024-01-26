package com.AuthLogin.infra.springBeans;

import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Lazy;

import lombok.AccessLevel;
import lombok.NonNull;

@Lazy
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LazyBean {
    @NonNull
    private String description;

    public LazyBean() {
        System.out.println("LazyBean Strated");
    }
}
