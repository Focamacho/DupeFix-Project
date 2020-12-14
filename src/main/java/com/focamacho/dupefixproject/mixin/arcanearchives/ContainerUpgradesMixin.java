package com.focamacho.dupefixproject.mixin.arcanearchives;

import com.aranaira.arcanearchives.inventory.ContainerUpgrades;
import com.aranaira.arcanearchives.tileentities.ImmanenceTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(targets = "com/aranaira/arcanearchives/inventory/ContainerUpgrades", remap = false)
public abstract class ContainerUpgradesMixin extends Container {
	
	public ImmanenceTileEntity tile;
	
    public ContainerUpgradesMixin(EntityPlayer player, ImmanenceTileEntity tile) {
        super();
    }

	@Override
    public boolean canInteractWith(EntityPlayer player) {
		BlockPos pos = this.tile.getPos();
		if (this.tile.getWorld().getTileEntity(pos) != this.tile) {
			return false;
		} else {
			return player.getDistanceSq(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) <= 64.0D;
		}
	}

}