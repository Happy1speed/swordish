package net.happyspeed.swordish.util.packets;

import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public class SwordishNetwork {
    public static void sendToServer(CustomPacketPayload payload) {
        Minecraft.getInstance().getConnection().send(payload);
    }
}

