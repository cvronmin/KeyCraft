package com.KanbeKotori.KeyCraft.Items;

import com.KanbeKotori.KeyCraft.KeyCraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

public class ModItems {
	
    public static Item PointShakingSword;
    public static Item PointAuroraTrident;
    public static Item PointAuroraBlade;
    public static Item SanaeBread;
    public static Item PeachJuice;
    public static Item MapoTofu;
    public static Item PizzaJam;
    
    public static void InitItems() {
    	//
    	// Init skills
    	//
    	
    	PointShakingSword = new PointShakingSword();
    	PointShakingSword.setUnlocalizedName("PointShakingSword").setTextureName("keycraft:PointShakingSword").setCreativeTab(null);
    	GameRegistry.registerItem(PointShakingSword, "PointShakingSword");
    	
    	PointAuroraTrident = new PointAuroraTrident();
    	PointAuroraTrident.setUnlocalizedName("PointAuroraTrident").setTextureName("keycraft:PointAuroraTrident").setCreativeTab(null);
    	GameRegistry.registerItem(PointAuroraTrident, "PointAuroraTrident");
    	
    	PointAuroraBlade = new PointAuroraBlade();
		PointAuroraBlade.setUnlocalizedName("PointAuroraBlade").setTextureName("keycraft:PointAuroraBlade").setCreativeTab(null);
    	GameRegistry.registerItem(PointAuroraBlade, "PointAuroraBlade");
    	
    	//
    	// Init food
    	//
    	
    	SanaeBread = (new ItemCallbackFood(20))
    			.setCallback(new ItemCallbackFood.ICallback(){
					public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
						if (!world.isRemote) {
				            player.setHealth(1);
				        }
					}
		    	})
    			.setUnlocalizedName("SanaeBread").setTextureName("keycraft:SanaeBread").setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(SanaeBread, "SanaeBread");
    	GameRegistry.addRecipe(new ItemStack(SanaeBread), new Object[] { "AAA", "ABA", "AAA", 'A', Items.rotten_flesh, 'B', Items.bread });
    	
    	PeachJuice = (new ItemFood(8, false))
    			.setPotionEffect(Potion.moveSlowdown.id, 10, 3, 1.0F)
    			.setUnlocalizedName("PeachJuice").setTextureName("keycraft:PeachJuice").setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(PeachJuice, "PeachJuice");
    	GameRegistry.addShapelessRecipe(new ItemStack(PeachJuice), new Object[] { Items.apple, Items.slime_ball });
    	
    	MapoTofu = (new ItemCallbackFood(10))
    			.setCallback(new ItemCallbackFood.ICallback(){
					public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
						if (!world.isRemote) {
							player.setFire(5);
				        }
					}
		    	})
    			.setPotionEffect(Potion.moveSpeed.id, 60, 3, 1.0F)
    			.setUnlocalizedName("MapoTofu").setTextureName("keycraft:MapoTofu").setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(MapoTofu, "MapoTofu");
    	GameRegistry.addRecipe(new ItemStack(MapoTofu), new Object[] { "ABA", "ACA", "AAA", 'A', new ItemStack(Items.dye, 1, 1), 
    																   'B', Items.blaze_powder, 'C', Items.bowl });
    	
    	PizzaJam = (new ItemFood(20, false))
    			.setPotionEffect(Potion.field_76443_y.id, 60, 0, 1.0F)
    			.setUnlocalizedName("PizzaJam").setTextureName("keycraft:PizzaJam").setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(PizzaJam, "PizzaJam");
    	//GameRegistry.addRecipe(new ItemStack(PizzaJam), new Object[] {  });
    }

}
