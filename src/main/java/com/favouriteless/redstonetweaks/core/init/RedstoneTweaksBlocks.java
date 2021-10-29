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

package com.favouriteless.redstonetweaks.core.init;

import com.favouriteless.redstonetweaks.common.blocks.*;
import com.favouriteless.redstonetweaks.common.blocks.ModPressurePlateBlock.Sensitivity;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class RedstoneTweaksBlocks {

    public static final Block ANDESITE_BUTTON = new ModButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F));
    public static final Block DIORITE_BUTTON = new ModButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F));
    public static final Block GRANITE_BUTTON = new ModButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F));
    public static final Block ANDESITE_PRESSURE_PLATE = new ModPressurePlateBlock(Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().noCollission().strength(0.5F));
    public static final Block DIORITE_PRESSURE_PLATE = new ModPressurePlateBlock(Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().noCollission().strength(0.5F));
    public static final Block GRANITE_PRESSURE_PLATE = new ModPressurePlateBlock(Sensitivity.MOBS, BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().noCollission().strength(0.5F));
    public static final Block TORCH_LEVER = new TorchLeverBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((state) -> 14).sound(SoundType.WOOD));
    public static final Block BOOKSHELF_SWITCH = new BookshelfSwitchBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.5F).sound(SoundType.WOOD).noOcclusion());

    public static void onInitialize() {
        Registry.register(Registry.BLOCK, new ResourceLocation("redstonetweaks", "andesite_button"), ANDESITE_BUTTON);
        Registry.register(Registry.BLOCK, new ResourceLocation("redstonetweaks", "diorite_button"), DIORITE_BUTTON);
        Registry.register(Registry.BLOCK, new ResourceLocation("redstonetweaks", "granite_button"), GRANITE_BUTTON);
        Registry.register(Registry.BLOCK, new ResourceLocation("redstonetweaks", "andesite_pressure_plate"), ANDESITE_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, new ResourceLocation("redstonetweaks", "diorite_pressure_plate"), DIORITE_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, new ResourceLocation("redstonetweaks", "granite_pressure_plate"), GRANITE_PRESSURE_PLATE);
        Registry.register(Registry.BLOCK, new ResourceLocation("redstonetweaks", "torch_lever"), TORCH_LEVER);
        Registry.register(Registry.BLOCK, new ResourceLocation("redstonetweaks", "bookshelf_switch"), BOOKSHELF_SWITCH);
    }

    public static void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(TORCH_LEVER, RenderType.cutout());
    }
}
