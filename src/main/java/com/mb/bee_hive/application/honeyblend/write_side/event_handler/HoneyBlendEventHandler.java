package com.mb.bee_hive.application.honeyblend.write_side.event_handler;

import com.mb.bee_hive.application.common.mappers.IMapper;
import com.mb.bee_hive.application.honeyblend.write_side.events.HoneyBlendCreatedEvent;
import com.mb.bee_hive.application.honeyblend.write_side.events.HoneyBlendDeletedEvent;
import com.mb.bee_hive.application.honeyblend.write_side.events.HoneyBlendUpdatedEvent;
import com.mb.bee_hive.insfrastructure.database.mysql.models.HoneyBlend;
import com.mb.bee_hive.insfrastructure.database.repositories.IHoneyBlendRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HoneyBlendEventHandler {

    private final IHoneyBlendRepository honeyBlendRepository;
    private final IMapper<HoneyBlendCreatedEvent, HoneyBlend> honeyBlendRepoMapper;
    private final IMapper<HoneyBlendUpdatedEvent, HoneyBlend> honeyBlendUpdatedRepoMapper;

    @Autowired
    public HoneyBlendEventHandler(IHoneyBlendRepository honeyBlendRepository, IMapper<HoneyBlendCreatedEvent, HoneyBlend> honeyBlendRepoMapper, IMapper<HoneyBlendUpdatedEvent, HoneyBlend> honeyBlendUpdatedRepoMapper){
        this.honeyBlendRepository = honeyBlendRepository;
        this.honeyBlendRepoMapper = honeyBlendRepoMapper;
        this.honeyBlendUpdatedRepoMapper = honeyBlendUpdatedRepoMapper;
    }

    @EventHandler
    public void handle(HoneyBlendUpdatedEvent event){
        HoneyBlend honeyBlend = honeyBlendUpdatedRepoMapper.map(event);
        honeyBlendRepository.store(honeyBlend);
    }

    @EventHandler
    public void handle(HoneyBlendDeletedEvent event){
        honeyBlendRepository.delete(event.getId());
    }

    @EventHandler
    public void on(HoneyBlendCreatedEvent event) {
        honeyBlendRepository.store(honeyBlendRepoMapper.map(event));
    }
}
