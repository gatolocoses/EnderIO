package com.enderio.base.common.capability;

import com.enderio.api.capability.IToggled;
import com.enderio.base.common.init.EIOCapabilities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.INBTSerializable;

public class Toggled implements IToggled, INBTSerializable<Tag> {

    private final ItemStack stack;

    public Toggled(ItemStack stack) {
        this.stack = stack;
    }

    public static boolean isEnabled(ItemStack itemStack) {
        return itemStack.getCapability(EIOCapabilities.TOGGLED).map(IToggled::isEnabled).orElse(false);
    }

    public static void toggleEnabled(ItemStack itemStack) {
        itemStack.getCapability(EIOCapabilities.TOGGLED).ifPresent(IToggled::toggle);
    }

    public static void setEnabled(ItemStack itemStack, boolean enabled) {
        itemStack.getCapability(EIOCapabilities.TOGGLED).ifPresent( iToggled -> iToggled.setEnabled(enabled));
    }

    @Override
    public boolean isEnabled() {
        CompoundTag tag = this.stack.getOrCreateTag();
        if (tag.contains("Toggled"))
            return tag.getBoolean("Toggled");
        return false;
    }

    @Override
    public void toggle() {
        setEnabled(!isEnabled());
    }

    @Override
    public void setEnabled(boolean isEnabled) {
        CompoundTag tag = this.stack.getOrCreateTag();
        tag.putBoolean("Toggled", isEnabled);
    }
}
