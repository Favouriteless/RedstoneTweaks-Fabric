package com.favouriteless.redstonetweaks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RedstoneTweaks implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("redstonetweaks");

	public static final Item TEST_ITEM = new Item(new FabricItemSettings().group(ItemGroup.REDSTONE).maxCount(1));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("redstonetweaks", "fabric_item"), TEST_ITEM);
	}
}
