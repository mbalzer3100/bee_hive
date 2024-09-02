package com.mb.bee_hive.application.honeyblend.write_side.policies;

import com.mb.bee_hive.application.common.exception.PolicyViolationException;
import com.mb.bee_hive.application.honeyblend.write_side.commands.CreateHoneyBlendCommand;

public class CreateHoneyBlendPolicy {
    public static void ensure(CreateHoneyBlendCommand command) throws PolicyViolationException {
        if(command.getName().isBlank() || command.getName().isEmpty() || command.getName() == null){
            throw new PolicyViolationException("The name of a new Honey Blend may not be empty.");
        }
    }
}
