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

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class RedstoneTweaksItems {

    public static final Item ANDESITE_BUTTON = new BlockItem(RedstoneTweaksBlocks.ANDESITE_BUTTON, new FabricItemSettings().group(CreativeModeTab.TAB_REDSTONE));
    public static final Item DIORITE_BUTTON = new BlockItem(RedstoneTweaksBlocks.DIORITE_BUTTON, new FabricItemSettings().group(CreativeModeTab.TAB_REDSTONE));
    public static final Item GRANITE_BUTTON = new BlockItem(RedstoneTweaksBlocks.GRANITE_BUTTON, new FabricItemSettings().group(CreativeModeTab.TAB_REDSTONE));
    public static final Item ANDESITE_PRESSURE_PLATE = new BlockItem(RedstoneTweaksBlocks.ANDESITE_PRESSURE_PLATE, new FabricItemSettings().group(CreativeModeTab.TAB_REDSTONE));
    public static final Item DIORITE_PRESSURE_PLATE = new BlockItem(RedstoneTweaksBlocks.DIORITE_PRESSURE_PLATE, new FabricItemSettings().group(CreativeModeTab.TAB_REDSTONE));
    public static final Item GRANITE_PRESSURE_PLATE = new BlockItem(RedstoneTweaksBlocks.GRANITE_PRESSURE_PLATE, new FabricItemSettings().group(CreativeModeTab.TAB_REDSTONE));
    public static final Item TORCH_LEVER = new BlockItem(RedstoneTweaksBlocks.TORCH_LEVER, new FabricItemSettings().group(CreativeModeTab.TAB_REDSTONE));
    public static final Item BOOKSHELF_SWITCH = new BlockItem(RedstoneTweaksBlocks.BOOKSHELF_SWITCH, new FabricItemSettings().group(CreativeModeTab.TAB_REDSTONE));

    public static void onInitialize() {
        Registry.register(Registry.ITEM, new ResourceLocation("redstonetweaks", "andesite_button"), ANDESITE_BUTTON);
        Registry.register(Registry.ITEM, new ResourceLocation("redstonetweaks", "diorite_button"), DIORITE_BUTTON);
        Registry.register(Registry.ITEM, new ResourceLocation("redstonetweaks", "granite_button"), GRANITE_BUTTON);
        Registry.register(Registry.ITEM, new ResourceLocation("redstonetweaks", "andesite_pressure_plate"), ANDESITE_PRESSURE_PLATE);
        Registry.register(Registry.ITEM, new ResourceLocation("redstonetweaks", "diorite_pressure_plate"), DIORITE_PRESSURE_PLATE);
        Registry.register(Registry.ITEM, new ResourceLocation("redstonetweaks", "granite_pressure_plate"), GRANITE_PRESSURE_PLATE);
        Registry.register(Registry.ITEM, new ResourceLocation("redstonetweaks", "torch_lever"), TORCH_LEVER);
        Registry.register(Registry.ITEM, new ResourceLocation("redstonetweaks", "bookshelf_switch"), BOOKSHELF_SWITCH);
    }
}
