
package gordanramsey.loves.babyeating.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.ResourceLocation;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class LootTableAfricaVillageChests extends ElementsBabyeatingMod.ModElement {
	public LootTableAfricaVillageChests(ElementsBabyeatingMod instance) {
		super(instance, 67);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		LootTableList.register(new ResourceLocation("babyeating", "africa/villchest"));
	}
}
