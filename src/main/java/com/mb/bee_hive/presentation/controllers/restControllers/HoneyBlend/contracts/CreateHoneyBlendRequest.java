package com.mb.bee_hive.presentation.controllers.restControllers.HoneyBlend.contracts;

import jakarta.validation.constraints.NotEmpty;

public record CreateHoneyBlendRequest(
        @NotEmpty
        String name,
        String description,
        int quantity
) {
}
