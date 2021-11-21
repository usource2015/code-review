package com.example.codereview.model.user;

import com.example.codereview.model.base.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base {
    @Column(name = "user_name")
    private String userName;
    @Column(name = "number_of_guesses")
    private Integer numberOfGuesses;

}
