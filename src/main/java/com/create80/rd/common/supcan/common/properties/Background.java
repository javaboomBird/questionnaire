/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.common.supcan.common.properties;

import com.create80.rd.common.supcan.annotation.common.properties.SupBackground;
import com.create80.rd.common.utils.ObjectUtils;
import com.create80.rd.common.supcan.annotation.common.properties.SupBackground;
import com.create80.rd.common.utils.ObjectUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 硕正TreeList Properties Background
 * @author WangZhen
 * @version 2013-11-04
 */
@XStreamAlias("Background")
public class Background {
	
	/**
	 * 背景颜色
	 */
	@XStreamAsAttribute
	private String bgColor = "#FDFDFD";
	
	public Background() {
		
	}
	
	public Background(SupBackground supBackground) {
		this();
		ObjectUtils.annotationToObject(supBackground, this);
	}
	
	public Background(String bgColor) {
		this();
		this.bgColor = bgColor;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
}
