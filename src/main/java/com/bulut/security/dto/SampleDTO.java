package com.bulut.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SampleDTO implements Serializable {

    private long id;
    private String name;
    private String surname;
    private int age;

    @Override
    public String toString() {
        return "SampleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
