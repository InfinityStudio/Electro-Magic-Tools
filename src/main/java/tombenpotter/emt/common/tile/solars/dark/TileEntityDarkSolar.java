/*******************************************************************************
 * Copyright (c) 2014 Tombenpotter.
 * All rights reserved. 
 *
 * This program and the accompanying materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at http://www.gnu.org/licenses/gpl.html
 *
 * This class was made by Tombenpotter and is distributed as a part of the Electro-Magic Tools mod.
 * Electro-Magic Tools is a derivative work on Thaumcraft 4 (c) Azanor 2012.
 * http://www.minecraftforum.net/topic/1585216-
 ******************************************************************************/

package tombenpotter.emt.common.tile.solars.dark;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import tombenpotter.emt.common.blocks.BlockRegistry;
import tombenpotter.emt.common.tile.solars.TileEntitySolarBase;
import tombenpotter.emt.common.util.ConfigHandler;

public class TileEntityDarkSolar extends TileEntitySolarBase {

    public TileEntityDarkSolar() {
        output = ConfigHandler.compressedSolarOutput;
    }

    @Override
    public void createEnergy() {
        if (worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord) && !worldObj.isDaytime() && !worldObj.isRaining() && !worldObj.isThundering()) {
            energySource.addEnergy(output);
        }
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return new ItemStack(BlockRegistry.emtSolars, 1, 6);
    }
}
