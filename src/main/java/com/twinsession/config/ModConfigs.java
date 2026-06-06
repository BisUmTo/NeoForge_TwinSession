package com.twinsession.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfigs {
    public static final ModConfigSpec CONFIG_SPEC;
    public static final ModConfigs CONFIG;

    public final ModConfigSpec.IntValue MAX_PLAYERS;
    public final ModConfigSpec.BooleanValue AUTO_WHITELIST;
    public final ModConfigSpec.BooleanValue AUTO_OP;
    public final ModConfigSpec.BooleanValue SPAWN_NEAR_PLAYER;
    public final ModConfigSpec.IntValue SPAWN_NEAR_PLAYER_RADIUS;
    public final ModConfigSpec.BooleanValue COPY_TEXTURE;
    public final ModConfigSpec.BooleanValue PREFIX_WITH_NUMBER;

    static {
        Pair<ModConfigs, ModConfigSpec> pair = new ModConfigSpec.Builder().configure(ModConfigs::new);
        CONFIG = pair.getLeft();
        CONFIG_SPEC = pair.getRight();
    }

    public ModConfigs(ModConfigSpec.Builder builder) {
        builder.push("general");

        MAX_PLAYERS = builder
                .comment("Max amount of re-joins per client.")
                .defineInRange("maxPlayers", 8, 1, Integer.MAX_VALUE);

        AUTO_WHITELIST = builder
                .comment("Automatically whitelist if whitelist is enabled.")
                .define("autoWhitelist", true);

        AUTO_OP = builder
                .comment("Automatically op if original client is also op.")
                .define("autoOp", true);

        SPAWN_NEAR_PLAYER = builder
                .comment("Spawn near the player, if false new players will join at world spawn.")
                .define("spawnNearPlayer", true);

        SPAWN_NEAR_PLAYER_RADIUS = builder
                .comment("If spawnNearPlayer is enabled, this will set the radius on who close the player should spawn.")
                .defineInRange("spawnNearPlayerRadius", 10, 1, Integer.MAX_VALUE);

        COPY_TEXTURE = builder
                .comment("Copy the texture of the original player.")
                .define("copyTexture", true);

        PREFIX_WITH_NUMBER = builder
                .comment("Adds a `$_` prefix to the username (Highly recommended to keep on true)")
                .define("prefixWithNumber", true);

        builder.pop();
    }
}