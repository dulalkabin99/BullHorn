package com.dulal.basic_bullhorn;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Bullhorn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=1, max = 140)
    private String content;

    @NotNull
    private Date date;

    @NotNull
    @Size(min=4)
    private String sentBy;

}
