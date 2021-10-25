/*
 * Copyright (c) 2021. Favouriteless
 * RedstoneTweaks-Fabric, a minecraft mod.
 * GNU GPLv3 License
 *
 *     This file is part of RedstoneTweaks-Fabric.
 *
 *     RedstoneTweaks-Fabric is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     RedstoneTweaks-Fabric is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with RedstoneTweaks-Fabric.  If not, see <https://www.gnu.org/licenses/>.
 *  
 */

package com.favouriteless.redstonetweaks.common.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Iterator;
import java.util.List;

public class ModPressurePlateBlock extends AbstractPressurePlateBlock {
    public static final BooleanProperty POWERED;
    private final ModPressurePlateBlock.ActivationRule type;

    public ModPressurePlateBlock(ModPressurePlateBlock.ActivationRule type, AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(POWERED, false));
        this.type = type;
    }

    protected int getRedstoneOutput(BlockState state) {
        return (Boolean)state.get(POWERED) ? 15 : 0;
    }

    protected BlockState setRedstoneOutput(BlockState state, int rsOut) {
        return (BlockState)state.with(POWERED, rsOut > 0);
    }

    protected void playPressSound(WorldAccess world, BlockPos pos) {
        if (this.material != Material.WOOD && this.material != Material.NETHER_WOOD) {
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.6F);
        } else {
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.8F);
        }

    }

    protected void playDepressSound(WorldAccess world, BlockPos pos) {
        if (this.material != Material.WOOD && this.material != Material.NETHER_WOOD) {
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.5F);
        } else {
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.7F);
        }

    }

    protected int getRedstoneOutput(World world, BlockPos pos) {
        Box box = BOX.offset(pos);
        List list3;
        switch(this.type) {
            case EVERYTHING:
                list3 = world.getOtherEntities((Entity)null, box);
                break;
            case MOBS:
                list3 = world.getNonSpectatingEntities(LivingEntity.class, box);
                break;
            default:
                return 0;
        }

        if (!list3.isEmpty()) {
            Iterator var5 = list3.iterator();

            while(var5.hasNext()) {
                Entity entity = (Entity)var5.next();
                if (!entity.canAvoidTraps()) {
                    return 15;
                }
            }
        }

        return 0;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    static {
        POWERED = Properties.POWERED;
    }

    public static enum ActivationRule {
        EVERYTHING,
        MOBS;
    }
}