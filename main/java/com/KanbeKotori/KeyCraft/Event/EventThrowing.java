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
package com.kanbekotori.keycraft.event;

import com.kanbekotori.keycraft.entities.EntityThrowableWithoutGravity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import cpw.mods.fml.common.eventhandler.Event;

public class EventThrowing extends Event {
	
public final EntityPlayer entityPlayer;
public final EntityThrowableWithoutGravity throwing;
	
	public EventThrowing(EntityPlayer entity, EntityThrowableWithoutGravity entitythrowing) {
		super();
		entityPlayer = entity;
		throwing = entitythrowing;
	}

}
