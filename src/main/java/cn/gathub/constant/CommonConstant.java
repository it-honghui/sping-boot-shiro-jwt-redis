package cn.gathub.constant;

public interface CommonConstant {

    /**
     * 删除标志 1 未删除 0
     */
    public static final Integer DEL_FLAG_1 = 1;

    public static final Integer DEL_FLAG_0 = 0;

    public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;

    public static final Integer SC_OK_200 = 200;

    /**
     * 访问权限认证未通过 510
     */
    public static final Integer SC_JEECG_NO_AUTHZ = 510;

    /**
     * 登录用户令牌缓存KEY前缀
     */
    public static final int TOKEN_EXPIRE_TIME = 3600; //3600秒即是一小时

    public static final String PREFIX_USER_TOKEN = "PREFIX_USER_TOKEN_";

    /**
     * 0：一级菜单
     */
    public static final Integer MENU_TYPE_0 = 0;

    /**
     * 1：子菜单
     */
    public static final Integer MENU_TYPE_1 = 1;

    /**
     * 2：按钮权限
     */
    public static final Integer MENU_TYPE_2 = 2;

    /**
     * 是否用户已被冻结 1(解冻)正常 2冻结
     */
    public static final Integer USER_UNFREEZE = 1;

    public static final Integer USER_FREEZE = 2;

    /**
     * token的key
     */
    public static String ACCESS_TOKEN = "Access-Token";

    /**
     * 登录用户规则缓存
     */
    public static final String LOGIN_USER_RULES_CACHE = "loginUser_cacheRules";

    /**
     * 登录用户拥有角色缓存KEY前缀
     */
    public static String LOGIN_USER_CACHERULES_ROLE = "loginUser_cacheRules::Roles_";

    /**
     * 登录用户拥有权限缓存KEY前缀
     */
    public static String LOGIN_USER_CACHERULES_PERMISSION = "loginUser_cacheRules::Permissions_";
}
