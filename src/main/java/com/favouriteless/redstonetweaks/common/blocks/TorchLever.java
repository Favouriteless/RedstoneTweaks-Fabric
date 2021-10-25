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

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeverBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Random;


public class TorchLever extends LeverBlock {

    public TorchLever(Settings settings) {
        super(settings);
    }

    public static final VoxelShape FLOOR_SHAPE = Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D);
    public static final VoxelShape CEILING_SHAPE = Block.createCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 10.0D, 10.0D);
    public static final VoxelShape WALL_SHAPE_NORTH = Block.createCuboidShape(5.5D, 3.0D, 11.0D, 10.5D, 13.0D, 16.0D);
    public static final VoxelShape WALL_SHAPE_SOUTH = Block.createCuboidShape(5.5D, 3.0D, 0.0D, 10.5D, 13.0D, 5.0D);
    public static final VoxelShape WALL_SHAPE_WEST = Block.createCuboidShape(11.0D, 3.0D, 5.5D, 16.0D, 13.0D, 10.5D);
    public static final VoxelShape WALL_SHAPE_EAST = Block.createCuboidShape(0.0D, 3.0D, 5.5D, 5.0D, 13.0D, 10.5D);


    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction dir = getDirection(state);
        return dir != Direction.DOWN && canPlaceAt(world, pos, dir.getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACE)) {
            case FLOOR -> FLOOR_SHAPE;
            case WALL -> switch (state.get(FACING)) {
                case EAST -> WALL_SHAPE_EAST;
                case WEST -> WALL_SHAPE_WEST;
                case SOUTH -> WALL_SHAPE_SOUTH;
                default -> WALL_SHAPE_NORTH;
            };
            case CEILING -> CEILING_SHAPE;
        };
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Direction direction = state.get(FACING);
        double d = (double)pos.getX() + 0.5D;
        double e = (double)pos.getY() + 0.7D;
        double f = (double)pos.getZ() + 0.5D;

        if (state.get(FACE) == WallMountLocation.WALL) {
            Direction direction2 = direction.getOpposite();
            if(state.get(POWERED)) {
                world.addParticle(ParticleTypes.SMOKE, d + 0.125D * (double) direction2.getOffsetX(), e + 0.04D, f + 0.125D * (double) direction2.getOffsetZ(), 0.0D, 0.0D, 0.0D);
                world.addParticle(ParticleTypes.FLAME, d + 0.125D * (double) direction2.getOffsetX(), e + 0.04D, f + 0.125D * (double) direction2.getOffsetZ(), 0.0D, 0.0D, 0.0D);
            } else {
                world.addParticle(ParticleTypes.SMOKE, d + 0.27D * (double) direction2.getOffsetX(), e + 0.22D, f + 0.27D * (double) direction2.getOffsetZ(), 0.0D, 0.0D, 0.0D);
                world.addParticle(ParticleTypes.FLAME, d + 0.27D * (double) direction2.getOffsetX(), e + 0.22D, f + 0.27D * (double) direction2.getOffsetZ(), 0.0D, 0.0D, 0.0D);
            }
        } else {
            if(state.get(POWERED)) {
                world.addParticle(ParticleTypes.SMOKE, d, e, f + 0.25D, 0.0D, 0.0D, 0.0D);
                world.addParticle(ParticleTypes.FLAME, d, e, f + 0.25D, 0.0D, 0.0D, 0.0D);
            } else {
                world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
                world.addParticle(ParticleTypes.FLAME, d, e, f, 0.0D, 0.0D, 0.0D);
            }
        }

        if (state.get(POWERED) && random.nextFloat() < 0.25F) {
            direction = state.get(FACING).getOpposite();
            Direction direction2 = getDirection(state).getOpposite();
            d = (double)pos.getX() + 0.5D + 0.1D * (double)direction.getOffsetX() + 0.2D * (double)direction2.getOffsetX();
            e = (double)pos.getY() + 0.5D + 0.1D * (double)direction.getOffsetY() + 0.2D * (double)direction2.getOffsetY();
            f = (double)pos.getZ() + 0.5D + 0.1D * (double)direction.getOffsetZ() + 0.2D * (double)direction2.getOffsetZ();
            world.addParticle(new DustParticleEffect(DustParticleEffect.RED, 0.5F), d, e, f, 0.0D, 0.0D, 0.0D);
        }
    }

}
