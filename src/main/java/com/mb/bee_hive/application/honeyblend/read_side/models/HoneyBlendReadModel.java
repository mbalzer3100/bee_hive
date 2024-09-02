package com.mb.bee_hive.application.honeyblend.read_side.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HoneyBlendReadModel {
    private String id;

    private String name;
    private String description;
    private int quantity;
}
