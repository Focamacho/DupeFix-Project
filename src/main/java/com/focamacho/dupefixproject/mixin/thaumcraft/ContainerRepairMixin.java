package com.focamacho.dupefixproject.mixin.thaumcraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.IInventory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import thaumcraft.api.items.ItemsTC;

@Mixin(ContainerRepair.class)
public class ContainerRepairMixin {

    @Shadow @Final private IInventory inputSlots;

    @Inject(method = "canInteractWith", at = @At("HEAD"), cancellable = true)
    private void canInteractWith(EntityPlayer player, CallbackInfoReturnable<Boolean> info) {
        if(this.inputSlots.getStackInSlot(1).getItem().equals(ItemsTC.primordialPearl)) info.setReturnValue(false);
    }

}
