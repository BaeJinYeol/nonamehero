package com.example.nonamehero.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_data")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "user_clear_zone", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "clear_zone")
    @Builder.Default
    private List<Boolean> clearZone = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "user_own_items", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "own_item")
    @Builder.Default
    private List<Integer> ownItems = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "user_put_on_item", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "put_on_item")
    @Builder.Default
    private List<Integer> putOnItem = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "user_put_on_dress", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "put_on_dress")
    @Builder.Default
    private List<Integer> putOnDress = new ArrayList<>();

    private int gold;
    private int level;
}

