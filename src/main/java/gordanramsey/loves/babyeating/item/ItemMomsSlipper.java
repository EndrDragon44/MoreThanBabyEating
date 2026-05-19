
package gordanramsey.loves.babyeating.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import java.util.Set;
import java.util.HashMap;

import gordanramsey.loves.babyeating.ElementsBabyeatingMod;

import com.google.common.collect.Multimap;

@ElementsBabyeatingMod.ModElement.Tag
public class ItemMomsSlipper extends ElementsBabyeatingMod.ModElement {
	@GameRegistry.ObjectHolder("babyeating:moms_slipper")
	public static final Item block = null;
	public ItemMomsSlipper(ElementsBabyeatingMod instance) {
		super(instance, 77);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSword(EnumHelper.addToolMaterial("MOMS_SLIPPER", 1, 45000, 4f, -3f, 20)) {
			@Override
			public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot slot) {
				Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);
				if (slot == EntityEquipmentSlot.MAINHAND) {
					multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
							new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.getAttackDamage(), 0));
					multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
							new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2, 0));
				}
				return multimap;
			}

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("sword", 1);
				return ret.keySet();
			}
		}.setUnlocalizedName("moms_slipper").setRegistryName("moms_slipper").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("babyeating:moms_slipper", "inventory"));
	}
}
