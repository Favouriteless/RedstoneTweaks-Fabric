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

import com.favouriteless.redstonetweaks.common.blocks.ButtonBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RedstoneTweaksBlocks {

    public static final Block ANDESITE_BUTTON = new ButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollision().strength(0.5F));
    public static final Block DIORITE_BUTTON = new ButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollision().strength(0.5F));
    public static final Block GRANITE_BUTTON = new ButtonBlock(AbstractBlock.Settings.of(Material.DECORATION).noCollision().strength(0.5F));

    public static void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("redstonetweaks", "andesite_button"), ANDESITE_BUTTON);
        Registry.register(Registry.BLOCK, new Identifier("redstonetweaks", "diorite_button"), DIORITE_BUTTON);
        Registry.register(Registry.BLOCK, new Identifier("redstonetweaks", "granite_button"), GRANITE_BUTTON);
    }
}
