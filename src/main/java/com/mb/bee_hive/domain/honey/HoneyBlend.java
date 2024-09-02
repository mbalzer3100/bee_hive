package com.mb.bee_hive.domain.honey;

import lombok.NonNull;

/**
 * This is the core Object of the program and represents the Honey Blend object later found in the DB.
 * Used for operations within the Domain Layer as well as for conversion between other layers.
 *
 * @param id is a unique Identifier for every Honey Blend
 * @param name the Name of the Honey Blend
 * @param description the Description of the Honey Blend
 * @param quantity currently present amount of the Honey Blend
 */
public record HoneyBlend(
        @NonNull
        HoneyBlendID id,
        @NonNull
        String name,
        String description,
        int quantity

) {
}
