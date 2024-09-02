package com.mb.bee_hive.application.honeyblend.write_side.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HoneyBlendDeletedEvent {
    private String id;
}
