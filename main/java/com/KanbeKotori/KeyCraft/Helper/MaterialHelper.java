package com.KanbeKotori.KeyCraft.Helper;

import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class MaterialHelper {
	
	public static ToolMaterial Aurora1 = EnumHelper.addToolMaterial("Aurora1", 0, 63, 0.0f, 7.0f, 0);
	public static ToolMaterial Aurora2 = EnumHelper.addToolMaterial("Aurora2", 3, 63, 10.0f, 8.0f, 0);
	public static ToolMaterial AuroraIron = EnumHelper.addToolMaterial("AuroraIron", 3, 127, 8.0f, 4.0f, 26);
	public static ToolMaterial HolyBreaker = EnumHelper.addToolMaterial("HolyBreaker", 4, 2048, 12.0f, 6.0f, 26);
	public static ToolMaterial ShakingSword = EnumHelper.addToolMaterial("ShakingSword", 0, 250, 0.0f, 12.0f, 0);
	public static ToolMaterial WirePole = EnumHelper.addToolMaterial("WirePole", 0, 127, 0.0f, 1.0f, 1);
	
	public static int[] AuroraIronVar = {3, 8, 6, 3};
	public static ArmorMaterial AuroraIronArmor = EnumHelper.addArmorMaterial("AuroraIron", 10, AuroraIronVar, 26);
	
}
