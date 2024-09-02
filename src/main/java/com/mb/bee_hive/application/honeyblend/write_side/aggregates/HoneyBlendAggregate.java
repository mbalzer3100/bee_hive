package com.mb.bee_hive.application.honeyblend.write_side.aggregates;

import com.mb.bee_hive.application.common.exception.PolicyViolationException;
import com.mb.bee_hive.application.honeyblend.write_side.commands.DeleteHoneyblendCommand;
import com.mb.bee_hive.application.honeyblend.write_side.commands.UpdateHoneyblendCommand;
import com.mb.bee_hive.application.honeyblend.write_side.events.HoneyBlendCreatedEvent;
import com.mb.bee_hive.application.honeyblend.write_side.commands.CreateHoneyBlendCommand;
import com.mb.bee_hive.application.honeyblend.write_side.events.HoneyBlendDeletedEvent;
import com.mb.bee_hive.application.honeyblend.write_side.events.HoneyBlendUpdatedEvent;
import com.mb.bee_hive.application.honeyblend.write_side.policies.CreateHoneyBlendPolicy;
import com.mb.bee_hive.application.honeyblend.write_side.policies.UpdateHoneyBlendPolicy;
import com.mb.bee_hive.insfrastructure.database.mysql.models.HoneyBlend;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class HoneyBlendAggregate {

    @AggregateIdentifier
    private String id;

    private String name;
    private String description;
    private int quantity;

    @CommandHandler
    public HoneyBlendAggregate(CreateHoneyBlendCommand createHoneyBlendCommand) throws PolicyViolationException {
        CreateHoneyBlendPolicy.ensure(createHoneyBlendCommand);

        HoneyBlendCreatedEvent event = HoneyBlendCreatedEvent
                .builder()
                .id(createHoneyBlendCommand.getId())
                .name(createHoneyBlendCommand.getName())
                .description(createHoneyBlendCommand.getDescription())
                .quantity(createHoneyBlendCommand.getQuantity())
                .build();

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public HoneyBlendAggregate(UpdateHoneyblendCommand updateHoneyblendCommand) throws PolicyViolationException {
        UpdateHoneyBlendPolicy.ensure(updateHoneyblendCommand);

        HoneyBlendUpdatedEvent event = HoneyBlendUpdatedEvent.builder()
                .id(updateHoneyblendCommand.getId())
                .name(updateHoneyblendCommand.getName())
                .description(updateHoneyblendCommand.getDescription())
                .quantity(updateHoneyblendCommand.getQuantity())
                .build();

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public HoneyBlendAggregate(DeleteHoneyblendCommand deleteHoneyblendCommand) throws PolicyViolationException {
        HoneyBlendDeletedEvent event = HoneyBlendDeletedEvent.builder()
                .id(deleteHoneyblendCommand.getId())
                .build();

        AggregateLifecycle.apply(event);
    }

    public HoneyBlendAggregate(){}

    @EventSourcingHandler
    public void on(HoneyBlendCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.quantity = event.getQuantity();
    }
}
