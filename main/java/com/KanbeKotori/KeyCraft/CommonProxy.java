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
package com.kanbekotori.keycraft;

import com.kanbekotori.keycraft.*;
import com.kanbekotori.keycraft.helper.MainHelper;
import com.kanbekotori.keycraft.items.*;
import com.kanbekotori.keycraft.network.RewriteNetwork;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		
	}
	 
	public void init(FMLInitializationEvent event) {
		// ע�������¼�
		FMLCommonHandler.instance().bus().register(new RewriteNetwork.SendSyncPacket());
		RewriteNetwork.rewriteChannel = NetworkRegistry.INSTANCE.newEventDrivenChannel(RewriteNetwork.REWRITE_CHANNEL);
		RewriteNetwork.rewriteChannel.register(new RewriteNetwork());
	}
	 
	public void postInit(FMLPostInitializationEvent event) {

	}
	
}
