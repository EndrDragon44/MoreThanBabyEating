
package gordanramsey.loves.babyeating.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

@ElementsBabyeatingMod.ModElement.Tag
public class ItemReinforcedSpermArmorArmor extends ElementsBabyeatingMod.ModElement {
	@GameRegistry.ObjectHolder("babyeating:reinforced_sperm_armor_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("babyeating:reinforced_sperm_armor_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("babyeating:reinforced_sperm_armor_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("babyeating:reinforced_sperm_armor_armorboots")
	public static final Item boots = null;
	public ItemReinforcedSpermArmorArmor(ElementsBabyeatingMod instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("REINFORCED_SPERM_ARMOR_ARMOR", "babyeating:reinforcedspermarmor", 90,
				new int[]{12, 36, 30, 12}, 54,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 5f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("reinforced_sperm_armor_armorhelmet")
				.setRegistryName("reinforced_sperm_armor_armorhelmet").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("reinforced_sperm_armor_armorbody")
				.setRegistryName("reinforced_sperm_armor_armorbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("reinforced_sperm_armor_armorlegs")
				.setRegistryName("reinforced_sperm_armor_armorlegs").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("reinforced_sperm_armor_armorboots")
				.setRegistryName("reinforced_sperm_armor_armorboots").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0,
				new ModelResourceLocation("babyeating:reinforced_sperm_armor_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("babyeating:reinforced_sperm_armor_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("babyeating:reinforced_sperm_armor_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("babyeating:reinforced_sperm_armor_armorboots", "inventory"));
	}
}
