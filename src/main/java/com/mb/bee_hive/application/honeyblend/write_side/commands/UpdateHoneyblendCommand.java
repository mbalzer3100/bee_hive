package com.mb.bee_hive.application.honeyblend.write_side.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@Builder
public class UpdateHoneyblendCommand {
    @TargetAggregateIdentifier
    private String id;

    private String name;
    private String description;
    private int quantity;
}
