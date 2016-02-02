/**
 * Copyright (c) Nulla Development Group, 2014-2015
 * ����Ʒ��Ȩ��Nulla���������С�
 * Developed by Kanbe-Kotori & xfgryujk.
 * ����Ʒ�� Kanbe-Kotori & xfgryujk ����������
 * This project is open-source, and it is distributed under
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * ����Ŀ��һ����Դ��Ŀ������ѭGNUͨ�ù�����ȨЭ�顣
 * �����ո�Э�������£����������ɴ������޸ġ�
 * http://www.gnu.org/licenses/gpl.html
 */
package com.kanbekotori.keycraft.items;

import com.kanbekotori.keycraft.*;
import com.kanbekotori.keycraft.helper.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;

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
    
    public static Item AuroraIronHelmet;
    public static Item AuroraIronChestPlate;
    public static Item AuroraIronLeggings;
    public static Item AuroraIronBoots;
    
    public static Item AuroraIronAxe;
    public static Item AuroraIronHoe;
    public static Item AuroraIronPickaxe;
    public static Item AuroraIronShovel;
    public static Item AuroraIronSword;
    
    public static Item HolyBreaker;
    
    public static Item Baseball;
    public static Item WirePole;
    public static Item Javelin;
    public static Item Dictionary;
    public static Item DictionaryOfWorld;
    public static Item DictionaryOfNether;
    public static Item DictionaryOfEnd;
    public static Item Violin;
    public static Item Gun;
    public static Item MiracleRibbon;
    
    public static void InitItems() {
    	// ע�Ἴ�����ɵ���Ʒ
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
    	
    	// ע��ʳ��
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
    	
    	// ע��������Ʒ
    	AuroraIronIngot = new ItemAuroraIronIngot()
    			.setUnlocalizedName("AuroraIronIngot")
    			.setTextureName("keycraft:AuroraIronIngot")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AuroraIronIngot, "AuroraIronIngot");
    	
    	AuroraIronHelmet = new Armors_AuroraIron(0)
    				.setUnlocalizedName("AuroraIronHelmet")
    				.setTextureName("keycraft:AuroraIronHelmet")
    				.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AuroraIronHelmet, "AuroraIronHelmet");
    	MainHelper.addEnchantedRecipe(AuroraIronHelmet, Enchantment.respiration, 1, new Object[] { "AAA", "A A", 'A', ModItems.AuroraIronIngot });
    	
    	AuroraIronChestPlate = new Armors_AuroraIron(1)
		.setUnlocalizedName("AuroraIronChestPlate")
		.setTextureName("keycraft:AuroraIronChestPlate")
		.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AuroraIronChestPlate, "AuroraIronChestPlate");
    	MainHelper.addEnchantedRecipe(AuroraIronChestPlate, Enchantment.thorns, 1, new Object[] { "A A", "AAA", "AAA", 'A', ModItems.AuroraIronIngot });
    	
    	AuroraIronLeggings = new Armors_AuroraIron(2)
    				.setUnlocalizedName("AuroraIronLeggings")
    				.setTextureName("keycraft:AuroraIronLeggings")
    				.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AuroraIronLeggings, "AuroraIronLeggings");
    	MainHelper.addEnchantedRecipe(AuroraIronLeggings, Enchantment.protection, 1, new Object[] { "AAA", "A A", "A A", 'A', ModItems.AuroraIronIngot });
    	
    	AuroraIronBoots = new Armors_AuroraIron(3)
    				.setUnlocalizedName("AuroraIronBoots")
    				.setTextureName("keycraft:AuroraIronBoots")
    				.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AuroraIronBoots, "AuroraIronBoots");
    	MainHelper.addEnchantedRecipe(AuroraIronBoots, Enchantment.featherFalling, 1, new Object[] { "A A", "A A", 'A', ModItems.AuroraIronIngot });
    	
    	AuroraIronAxe = new ItemAuroraIronAxe()
    				.setUnlocalizedName("AuroraIronAxe")
    				.setTextureName("keycraft:AuroraIronAxe")
    				.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AuroraIronAxe, "AuroraIronAxe");
    	MainHelper.addEnchantedRecipe(AuroraIronAxe, Enchantment.efficiency, 1, new Object[] { "AA", "AB", " B" , 'A', ModItems.AuroraIronIngot, 'B', Items.stick });

    	AuroraIronHoe = new ItemAuroraIronHoe()
		.setUnlocalizedName("AuroraIronHoe")
		.setTextureName("keycraft:AuroraIronHoe")
		.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AuroraIronHoe, "AuroraIronHoe");
    	MainHelper.addEnchantedRecipe(AuroraIronHoe, Enchantment.looting, 1, new Object[] { "AA", " B", " B" , 'A', ModItems.AuroraIronIngot, 'B', Items.stick });

    	
    	AuroraIronPickaxe = new ItemAuroraIronPickaxe()
    					.setUnlocalizedName("AuroraIronPickaxe")
    					.setTextureName("keycraft:AuroraIronPickaxe")
    					.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AuroraIronPickaxe, "AuroraIronPickaxe");
    	MainHelper.addEnchantedRecipe(AuroraIronPickaxe, Enchantment.fortune, 1, new Object[] { "AAA", " B ", " B ", 'A', ModItems.AuroraIronIngot, 'B', Items.stick });

    	AuroraIronShovel = new ItemAuroraIronShovel()
    				.setUnlocalizedName("AuroraIronShovel")
    				.setTextureName("keycraft:AuroraIronShovel")
    				.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AuroraIronShovel, "AuroraIronShovel");
    	MainHelper.addEnchantedRecipe(AuroraIronShovel, Enchantment.unbreaking, 1, new Object[] { "A", "B", "B", 'A', ModItems.AuroraIronIngot, 'B', Items.stick });

    	
    	AuroraIronSword = new ItemAuroraIronSword()
    				.setUnlocalizedName("AuroraIronSword")
    				.setTextureName("keycraft:AuroraIronSword")
    				.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(AuroraIronSword, "AuroraIronSword");
    	MainHelper.addEnchantedRecipe(AuroraIronSword, Enchantment.sharpness, 1, new Object[] { "A", "A", "B", 'A', ModItems.AuroraIronIngot, 'B', Items.stick });
    	
    	HolyBreaker = new ItemHolyBreaker()
    			.setUnlocalizedName("HolyBreaker")
    			.setTextureName("keycraft:HolyBreaker")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(HolyBreaker, "HolyBreaker");
    	MaterialHelper.HolyBreaker.setRepairItem(new ItemStack(Items.nether_star));
    	GameRegistry.addRecipe(new ItemStack(HolyBreaker), new Object[] { "ABA", "ACA", " C ", 'A', ModItems.AuroraIronIngot, 'B', Items.nether_star, 'C', Blocks.obsidian });
    	
    	Baseball = (new ItemBaseball())
    			.setMaxStackSize(16)
    			.setUnlocalizedName("Baseball")
    			.setTextureName("keycraft:Baseball")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(Baseball, "Baseball");
    	GameRegistry.addRecipe(new ItemStack(Baseball, 4), new Object[] { " A ", "ABA", " A ", 'A', Items.leather, 'B', Blocks.planks });
    	
    	WirePole = (new ItemWirePole())
    			.setUnlocalizedName("WirePole")
    			.setTextureName("keycraft:WirePole")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(WirePole, "WirePole");
    	GameRegistry.addRecipe(new ItemStack(WirePole), new Object[] { "ABA", "ABA", "ABA", 'A', Blocks.stone, 'B', Items.iron_ingot });
    	MaterialHelper.WirePole.setRepairItem(new ItemStack(Blocks.stone));
    	
    	Javelin = (new ItemJavelin())
    			.setMaxStackSize(16)
    			.setUnlocalizedName("Javelin")
    			.setTextureName("keycraft:Javelin")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(Javelin, "Javelin");
    	GameRegistry.addRecipe(new ItemStack(Javelin), new Object[] { "A  ", " A ", "  A", 'A', Items.iron_ingot });
    	
    	Dictionary = (new ItemDictionary())
    			.setUnlocalizedName("Dictionary")
    			.setTextureName("keycraft:Dictionary")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(Dictionary, "Dictionary");
    	GameRegistry.addRecipe(new ItemStack(Dictionary), new Object[] { " AA", "ABB", " AA", 'A', Items.leather, 'B', Items.paper });
    	GameRegistry.addRecipe(new ItemStack(Dictionary), new Object[] { "AA ", "BBA", "AA ", 'A', Items.leather, 'B', Items.paper });
    	
    	DictionaryOfWorld = (new ItemDictionaryOfWorld())
    			.setUnlocalizedName("DictionaryOfWorld")
    			.setTextureName("keycraft:Dictionary")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(DictionaryOfWorld, "DictionaryOfWorld");
    	GameRegistry.addRecipe(new ItemStack(DictionaryOfWorld), new Object[] { "CAA", "ABB", " AA", 'A', Items.leather, 'B', Items.paper, 'C', Blocks.grass });
    	GameRegistry.addRecipe(new ItemStack(DictionaryOfWorld), new Object[] { "AAC", "BBA", "AA ", 'A', Items.leather, 'B', Items.paper, 'C', Blocks.grass });
    	GameRegistry.addRecipe(new ItemStack(DictionaryOfWorld), new Object[] { "A", "B", 'A', Blocks.grass, 'B', Dictionary });
    	
    	DictionaryOfNether = (new ItemDictionaryOfNether())
    			.setUnlocalizedName("DictionaryOfNether")
    			.setTextureName("keycraft:Dictionary")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(DictionaryOfNether, "DictionaryOfNether");
    	GameRegistry.addRecipe(new ItemStack(DictionaryOfNether), new Object[] { "CAA", "ABB", " AA", 'A', Items.leather, 'B', Items.paper, 'C', Blocks.netherrack });
    	GameRegistry.addRecipe(new ItemStack(DictionaryOfNether), new Object[] { "AAC", "BBA", "AA ", 'A', Items.leather, 'B', Items.paper, 'C', Blocks.netherrack });
    	GameRegistry.addRecipe(new ItemStack(DictionaryOfNether), new Object[] { "A", "B", 'A', Blocks.netherrack, 'B', Dictionary });
    	
    	DictionaryOfEnd = (new ItemDictionaryOfEnd())
    			.setUnlocalizedName("DictionaryOfEnd")
    			.setTextureName("keycraft:Dictionary")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(DictionaryOfEnd, "DictionaryOfEnd");
    	GameRegistry.addRecipe(new ItemStack(DictionaryOfEnd), new Object[] { "CAA", "ABB", " AA", 'A', Items.leather, 'B', Items.paper, 'C', Blocks.end_stone });
    	GameRegistry.addRecipe(new ItemStack(DictionaryOfEnd), new Object[] { "AAC", "BBA", "AA ", 'A', Items.leather, 'B', Items.paper, 'C', Blocks.end_stone });
    	GameRegistry.addRecipe(new ItemStack(DictionaryOfEnd), new Object[] { "A", "B", 'A', Blocks.end_stone, 'B', Dictionary });
 
    	Violin = (new ItemViolin())
    			.setUnlocalizedName("Violin")
    			.setTextureName("keycraft:Violin")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(Violin, "Violin");
	    GameRegistry.addRecipe(new ShapedOreRecipe(Violin, new Object[] { " A ", "ABA", "ABA", 'A', "logWood", 'B', Items.string }));
    	
    	Gun = (new ItemGun())
    			.setUnlocalizedName("Gun")
    			.setTextureName("keycraft:Gun")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(Gun, "Gun");
    	GameRegistry.addRecipe(new ItemStack(Gun), new Object[] { "AAA", " BA", "  A", 'A', Items.iron_ingot, 'B', Blocks.wooden_button });
    	GameRegistry.addRecipe(new ItemStack(Gun), new Object[] { "AAA", "AB ", "A  ", 'A', Items.iron_ingot, 'B', Blocks.wooden_button });

    	MiracleRibbon = (new Item())
    			.setUnlocalizedName("MiracleRibbon")
    			.setTextureName("keycraft:MiracleRibbon")
    			.setCreativeTab(KeyCraft.CreativeTab);
    	GameRegistry.registerItem(MiracleRibbon, "MiracleRibbon");
    	
    }

}
