package com.mb.bee_hive.presentation.controllers.restControllers.HoneyBlend.contracts;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record UpdateHoneyBlendRequest(
        String id,
        @NotEmpty
        String name,
        String description,
        int quantity
) {
}
