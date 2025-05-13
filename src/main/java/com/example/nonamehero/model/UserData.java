package com.example.nonamehero.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 기본 키를 위한 id 필드

    @ElementCollection
    @CollectionTable(name = "user_clear_zone", joinColumns = @jakarta.persistence.JoinColumn(name = "user_id"))
    @Column(name = "clear_zone")
    private List<Boolean> clearZone;

    @ElementCollection
    @CollectionTable(name = "user_own_items", joinColumns = @jakarta.persistence.JoinColumn(name = "user_id"))
    @Column(name = "own_item")
    private List<Integer> ownItems;

    @ElementCollection
    @CollectionTable(name = "user_put_on_item", joinColumns = @jakarta.persistence.JoinColumn(name = "user_id"))
    @Column(name = "put_on_item")
    private List<Integer> putOnItem;

    @ElementCollection
    @CollectionTable(name = "user_put_on_dress", joinColumns = @jakarta.persistence.JoinColumn(name = "user_id"))
    @Column(name = "put_on_dress")
    private List<Integer> putOnDress;

    private int gold;
    private int level;
}
