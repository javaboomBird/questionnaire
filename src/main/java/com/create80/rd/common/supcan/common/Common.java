/**
 * Copyright &copy; 2012-2016  All rights reserved.
 */
package com.create80.rd.common.supcan.common;

import com.create80.rd.common.supcan.common.fonts.Font;
import com.create80.rd.common.supcan.common.properties.Properties;
import com.create80.rd.common.utils.IdGen;
import java.util.List;

import com.google.common.collect.Lists;
import com.create80.rd.common.supcan.common.fonts.Font;
import com.create80.rd.common.supcan.common.properties.Properties;
import com.create80.rd.common.utils.IdGen;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 硕正Common
 * @author WangZhen
 * @version 2013-11-04
 */
public class Common {

	/**
	 * 属性对象
	 */
	@XStreamAlias("Properties")
	protected Properties properties;
	
	/**
	 * 字体对象
	 */
	@XStreamAlias("Fonts")
	protected List<Font> fonts;

	public Common() {
		properties = new Properties(IdGen.uuid());
		fonts = Lists.newArrayList(
				new Font("宋体", "134", "-12"),
				new Font("宋体", "134", "-13", "700"));
	}
	
	public Common(Properties properties) {
		this();
		this.properties = properties;
	}
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List<Font> getFonts() {
		return fonts;
	}

	public void setFonts(List<Font> fonts) {
		this.fonts = fonts;
	}

}
