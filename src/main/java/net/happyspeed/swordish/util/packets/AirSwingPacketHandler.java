package net.happyspeed.swordish.util.packets;

import net.happyspeed.swordish.events.AttackSwingListener;
import net.happyspeed.swordish.items.templates.SwordishBase;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class AirSwingPacketHandler {
    public static void handle(AirSwingPacket msg, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            if (ctx.player() instanceof ServerPlayer player) {
                AttackSwingListener.handleAttackSwing(player);
            }
        });
    }
}

