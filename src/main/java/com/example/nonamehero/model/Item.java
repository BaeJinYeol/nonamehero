package com.example.nonamehero.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {

    @Id
    private int item_id;

    private String item_name;
    private String description;
    private String icon_path;
    private int hp;
    private int power;
    private int speed;
    private int attack_speed;
    private int critical_rate;
    private int type;
}
