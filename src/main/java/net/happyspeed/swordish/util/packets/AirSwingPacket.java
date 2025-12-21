package net.happyspeed.swordish.util.packets;

import net.happyspeed.swordish.items.templates.SwordishBase;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
public record AirSwingPacket() implements CustomPacketPayload {

    public static final Type<AirSwingPacket> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath("swordish", "air_swing"));

    @Override
    public Type<AirSwingPacket> type() {
        return TYPE;
    }

    public static final StreamCodec<RegistryFriendlyByteBuf, AirSwingPacket> CODEC =
            StreamCodec.unit(new AirSwingPacket());
}


