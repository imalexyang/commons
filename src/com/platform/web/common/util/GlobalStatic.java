package com.platform.web.common.util;

/**
 */
public class GlobalStatic {
	public static final String tempRootpath = System.getProperty("user.dir") + "/temp/";
	public static final int excelPageSize=1000;
	public static final  String suffix=".html";
	public static final String excelext=".xls";
	public static final String exportexcel="exportexcel";//是否是导出操作的key
	public static final String dataUpdate="更新";
	public static final String dataSave="保存";
	public static final String dataDelete="删除";
	public static final String cacheKey="springraincache";
	public static final String userMenucache ="userMenucache";
	public static final String qxCacheKey="springrainqxcache";
	public static final String tableExt="_history_";
	public static final String frameTableAlias="frameTableAlias";
	
	//认证
	//public static final String reloginsession="shiro-reloginsession";
	//认证
	public static final String authenticationCacheName="shiro-authenticationCacheName";
	//授权
	public static final String authorizationCacheName="shiro-authorizationCacheName";
	//realm名称
	public static final String authorizingRealmName="shiroDbAuthorizingRealmName";
	/**
	 * 默认验证码参数名称
	 */
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	/**
	 * 登录次数超出allowLoginNum时，存储在session记录是否展示验证码的key默认名称
	 */
	public static final String DEFAULT_SHOW_CAPTCHA_KEY_ATTRIBUTE = "showCaptcha";

	/**
	 * 默认在session中存储的登录次数名称
	 */
	public static final String DEFAULT_LOGIN_NUM_KEY_ATTRIBUTE = "loginNum";
	  //允许登录次数，当登录次数大于该数值时，会在页面中显示验证码
	public static final Integer allowLoginNum=1;
	
	public static String TEMPSTRING;
	
}
