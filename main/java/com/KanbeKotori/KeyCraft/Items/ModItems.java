package com.KanbeKotori.KeyCraft.Items;

import com.KanbeKotori.KeyCraft.*;
import com.KanbeKotori.KeyCraft.Helper.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ModItems {
	
    public static Item ShakingSword;
    public static Item AuroraTrident;
    public static Item AuroraBlade;
    
    public static Item SanaeBread;
    public static Item PeachJuice;
    public static Item MapoTofu;
    public static Item PizzaJam;
    public static Item AkikoJam;
    public static Item BreadWithJam;
    
    public static Item AuroraIronIngot;
    public static Item HolyBreaker;

    
    public static Item Baseball;
    public static Item WirePole;
    
    public static void InitItems() {
    	// 注册技能生成的物品
    	ShakingSword = new ItemShakingSword()
    				.setUnlocalizedName("ShakingSword")
    				.setTextureName("keycraft:ShakingSword")
    				.setCreativeTab(null);
    	GameRegistry.registerItem(ShakingSword, "ShakingSword");
    	
    	AuroraTrident = new ItemAuroraTrident()
    				 .setUnlocalizedName("AuroraTrident")
    				 .setTextureName("keycraft:AuroraTrident")
    				 .setCreativeTab(null);
    	GameRegistry.registerItem(AuroraTrident, "AuroraTrident");
    	
    	AuroraBlade = new ItemAuroraBlade()
    			   .setUnlocalizedName("AuroraBlade")
    			   .setTextureName("keycraft:AuroraBlade")
    			   .setCreativeTab(null);
    	GameRegistry.registerItem(AuroraBlade, "AuroraBlade");
    	
    	// 注册食物
    	SanaeBread = (new ItemCallbackFood(20))
    			  .setCallback(new ItemCallbackFood.ICallback() {
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
							player.setFire(30);
				        }
					}
		    	})
    			.setPotionEffect(Potion.moveSpeed.id, 60, 3, 1.0F)
    			.setUnlocalizedName("MapoTofu").setTextureName("keycraft:MapoTofu").setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(MapoTofu, "MapoTofu");
    	GameRegistry.addRecipe(new ItemStack(MapoTofu), new Object[] { "ABA", "ACA", "AAA", 'A', new ItemStack(Items.dye, 1, 1), 
    																   'B', Items.blaze_powder, 'C', Items.bowl });
    	
    	PizzaJam = (new ItemCallbackFood(4))
    			.setCallback(new ItemCallbackFood.ICallback(){
					public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
						player.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 30 * 20, -1));
						player.addPotionEffect(new PotionEffect(Potion.confusion.id, 30 * 20, 3));
					}
		    	})
    			.setUnlocalizedName("PizzaJam").setTextureName("keycraft:PizzaJam").setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(PizzaJam, "PizzaJam");
    	GameRegistry.addRecipe(new ItemStack(PizzaJam), new Object[] { "AAA", "ABA", "ACA", 'A', Items.sugar, 'B', Items.glass_bottle, 'C', new ItemStack(Items.dye, 1, 1) });
    	
    	AkikoJam = (new ItemFood(4, false))
    			.setPotionEffect(Potion.confusion.id, 20, 3, 1.0F)
    			.setUnlocalizedName("AkikoJam").setTextureName("keycraft:AkikoJam").setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AkikoJam, "AkikoJam");
    	GameRegistry.addRecipe(new ItemStack(AkikoJam), new Object[] { "AAA", "ABA", "AAA", 'A', Blocks.yellow_flower, 'B', Items.glass_bottle });
    	
    	BreadWithJam = (new ItemBreadWithJam(-20))
    			.setPotionEffect(Potion.confusion.id, 60, 3, 1.0F)
    			.setUnlocalizedName("BreadWithJam")
    			.setTextureName("keycraft:SanaeBread")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(BreadWithJam, "BreadWithJam");
    	GameRegistry.addShapelessRecipe(new ItemStack(BreadWithJam), new Object[] { SanaeBread, AkikoJam });
    	
    	// 注册其他物品
    	AuroraIronIngot = new ItemAuroraIronIngot()
    				.setUnlocalizedName("AuroraIronIngot")
    				.setTextureName("keycraft:AuroraIronIngot")
    				.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AuroraIronIngot, "AuroraIronIngot");
    	
    	HolyBreaker = new ItemHolyBreaker()
    			.setUnlocalizedName("HolyBreaker")
    			.setTextureName("keycraft:HolyBreaker")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(HolyBreaker, "HolyBreaker");
    	ToolMaterialHelper.HolyBreaker.setRepairItem(new ItemStack(Items.nether_star));
    	GameRegistry.addRecipe(new ItemStack(HolyBreaker), new Object[] { "ABA", "ACA", " C ", 'A', ModItems.AuroraIronIngot, 'B', Items.nether_star, 'C', Blocks.obsidian });
    	
    	Baseball = (new ItemBaseball())
    			.setMaxStackSize(16)
    			.setUnlocalizedName("Baseball").setTextureName("keycraft:Baseball").setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(Baseball, "Baseball");
    	GameRegistry.addRecipe(new ItemStack(Baseball, 4), new Object[] { " A ", "ABA", " A ", 'A', Items.leather, 'B', Blocks.planks });
    	
    	WirePole = (new ItemWirePole())
    			.setUnlocalizedName("WirePole").setTextureName("keycraft:WirePole").setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(WirePole, "WirePole");
    	GameRegistry.addRecipe(new ItemStack(WirePole), new Object[] { "ABA", "ABA", "ABA", 'A', Blocks.stone, 'B', Items.iron_ingot });
    	ToolMaterialHelper.WirePole.setRepairItem(new ItemStack(Blocks.stone));
    }

}
