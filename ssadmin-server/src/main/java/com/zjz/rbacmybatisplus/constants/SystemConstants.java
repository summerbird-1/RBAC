package com.zjz.rbacmybatisplus.constants;

public class SystemConstants
{
    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    public static final String STATUS_NORMAL = "0";
    /**
    * 友链审核通过
    */
    public static final String LINK_STATUS_NORMAL = "0";
    /**
     * 根评论
     */
    public static final int ROOT_COMMENT = -1;

    /**
     * 评论类型为文章评论
     */
    public static final String  ARTICLE_COMMENT = "0";
    /**
     * 评论类型为友链评论
     */

    public static final String  LINK_COMMENT = "1";

    public static final String  MENU = "C";

    public static final String  BUTTON = "F";

    public static final int DELETE_TAG = 1;
    /**
     * 标签状态为正常
     */
    public static final int NORMAL = 0;
    public static final String ADMIN = "1";
}