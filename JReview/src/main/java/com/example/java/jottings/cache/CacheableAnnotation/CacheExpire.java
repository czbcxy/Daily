package com.example.java.jottings.cache.CacheableAnnotation;

/**
 * @描述
 * @参数 $params$
 * @返回值 $return$
 * @创建人 czb
 * @创建时间 $date$
 * @修改人和其它信息
 */
public enum CacheExpire {
    /**
     * 无固定期限
     */
    NONE(0, "无固定期限")

    /**
     * 1秒钟
     */
    ,ONE_SEC(1, "1秒钟")

    /**
     * 5秒钟
     */
    ,FIVE_SEC(5, "5秒钟")

    /**
     * 10秒钟
     */
    ,TEN_SEC(10, "10秒钟")

    /**
     * 30秒钟
     */
    ,HALF_A_MIN(30, "30秒钟")

    /**
     * 1分钟
     */
    ,ONE_MIN(60, "1分钟")

    /**
     * 5分钟
     */
    ,FIVE_MIN(5 * 60, "5分钟")

    /**
     * 10分钟
     */
    ,TEN_MIN(10 * 60, "10分钟")

    /**
     * 20分钟
     */
    ,TWENTY_MIN(20 * 60, "20分钟")

    /**
     * 30分钟
     */
    ,HALF_AN_HOUR(30 * 60, "30分钟")

    /**
     * 1小时
     */
    ,ONE_HOUR(60 * 60, "1小时")

    /**
     * 1天
     */
    ,ONE_DAY(24 * 60 * 60, "1天")

    /**
     * 半天
     */
    ,HALF_A_DAY(12 * 60 * 60, "半天")
    /**
     * 1个月
     */
    ,ONE_MON(30 * 24 * 60 * 60, "1个月")

    /**
     * 1年
     */
    ,ONE_YEAR(365 * 24 * 60 * 60, "1年")

    ;

    /**
     * 时间
     */
    private final int time;
    /**
     * 描述
     */
    private final String desc;

    CacheExpire(int time, String desc) {
        this.time = time;
        this.desc = desc;
    }


    /**
     * 获取具体时间
     * @return
     */
    public int getTime() {
        return time;
    }

    /**
     * 获取时间描述信息
     * @return
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 根据时间匹配失效期限
     * @param time
     * @return
     */
    public static CacheExpire matchTime(int time) {
        CacheExpire[] expires = CacheExpire.values();
        for (CacheExpire expire : expires) {
            if (expire.getTime() == time) {
                return expire;
            }
        }
        return HALF_AN_HOUR;
    }

    public static void main(String[] args) {
        System.out.println(matchTime(60 * 60).getDesc());
    }
}
