package com.JEONG.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue
    private Long id;
    @Setter
    private Long restaurantId;

    private  String name;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT) //false 가 아니면 넣어줘라
    private  boolean destroy;

}
