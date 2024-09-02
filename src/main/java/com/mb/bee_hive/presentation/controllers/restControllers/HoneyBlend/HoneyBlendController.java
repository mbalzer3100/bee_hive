package com.mb.bee_hive.presentation.controllers.restControllers.HoneyBlend;

import com.mb.bee_hive.application.honeyblend.read_side.models.HoneyBlendReadModel;
import com.mb.bee_hive.application.honeyblend.read_side.queries.GetAllHoneyBlendQuery;
import com.mb.bee_hive.application.honeyblend.read_side.queries.GetSpecificHoneyBlendQuery;
import com.mb.bee_hive.application.honeyblend.write_side.commands.CreateHoneyBlendCommand;
import com.mb.bee_hive.application.honeyblend.write_side.commands.DeleteHoneyblendCommand;
import com.mb.bee_hive.application.honeyblend.write_side.commands.UpdateHoneyblendCommand;
import com.mb.bee_hive.insfrastructure.database.repositories.IHoneyBlendRepository;
import com.mb.bee_hive.presentation.controllers.restControllers.HoneyBlend.contracts.CreateHoneyBlendRequest;
import com.mb.bee_hive.presentation.controllers.restControllers.HoneyBlend.contracts.UpdateHoneyBlendRequest;
import jdk.jshell.spi.ExecutionControl;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/honeyBlend")
public class HoneyBlendController {
    private final IHoneyBlendRepository honeyBlendRepository;
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Autowired
    public HoneyBlendController(IHoneyBlendRepository honeyBlendRepository, CommandGateway commandGateway, QueryGateway queryGateway) {
        this.honeyBlendRepository = honeyBlendRepository;
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @GetMapping("/{id}")
    public HoneyBlendReadModel get(@PathVariable String id) {
        GetSpecificHoneyBlendQuery query = GetSpecificHoneyBlendQuery.builder()
                .id(id)
                .build();
        return queryGateway.query(query, ResponseTypes.instanceOf(HoneyBlendReadModel.class)).join();
    }

    @GetMapping
    public List<HoneyBlendReadModel> getAll() throws ExecutionControl.NotImplementedException {
        List<HoneyBlendReadModel> honeyBlendReadModels;
        GetAllHoneyBlendQuery query = new GetAllHoneyBlendQuery();
        honeyBlendReadModels = queryGateway.query(query, ResponseTypes.multipleInstancesOf(HoneyBlendReadModel.class))
                .join();
        return honeyBlendReadModels;
    }

    @PutMapping("/{id}")
    public void updateHoneyBlend(@PathVariable String id, @RequestBody UpdateHoneyBlendRequest request) {
        UpdateHoneyblendCommand command = UpdateHoneyblendCommand.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .quantity(request.quantity())
                .build();

        commandGateway.sendAndWait(command);
    }

    @DeleteMapping("/{id}")
    public void deleteHoneyBlend(@PathVariable String id) {
        DeleteHoneyblendCommand command = DeleteHoneyblendCommand.builder()
                .id(id)
                .build();
        commandGateway.sendAndWait(command);
    }

    @PostMapping
    public String createHoneyBlend(@RequestBody CreateHoneyBlendRequest request) {
        CreateHoneyBlendCommand command = CreateHoneyBlendCommand.builder()
                .id(UUID.randomUUID().toString())
                .name(request.name())
                .description(request.description())
                .quantity(request.quantity())
                .build();

        return commandGateway.sendAndWait(command);
    }
}
