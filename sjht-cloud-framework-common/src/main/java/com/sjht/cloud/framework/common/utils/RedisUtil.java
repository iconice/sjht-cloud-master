//package com.sjht.cloud.framework.common.utils;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//
//import com.alibaba.fastjson.JSONObject;
//
///**
// * *********************************************
// * @ClassName: RedisUtil
// * @Description: redis操作类
// * @Author maojianyun
// * @Date 2019/11/30 23:25
// * @Version V1.0
// * *********************************************
// */
//@Service
//public class RedisUtil {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    /**
//     * 得到可以的时间
//     * @param key
//     * @return
//     */
//    public long getExpire(String key){
//        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: expire
//     * @Description: 设置过期时间
//     * @Param: key 键
//     * @Param: time 过期时间（秒）
//     * @Return: boolean
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean expire(String key, long time) {
//
//        try {
//            if (time > 0) {
//                redisTemplate.expire(key, time, TimeUnit.SECONDS);
//            }
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("设置过期时间异常key=" + key, e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hasKey
//     * @Description: 判断key是否存在
//     * @Param: key 键
//     * @Return: boolean true存在 false不存在
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean hasKey(String key) {
//        try {
//            return redisTemplate.hasKey(key);
//        } catch (Exception e) {
//            LOGGER.error("判断key是否存在异常key=" + key, e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: del
//     * @Description: 删除缓存
//     * @Param: key 可以传一个值 或多个
//     * @Return: void
//     * @Author maojianyun
//     * *********************************************************
//     */
//    @SuppressWarnings("unchecked")
//    public void del(String... key) {
//        if (key != null && key.length > 0) {
//            if (key.length == 1) {
//                redisTemplate.delete(key[0]);
//            } else {
//                redisTemplate.delete(CollectionUtils.arrayToList(key));
//            }
//        }
//
//    }
//    /******************************************String开始***********************************/
//    /**
//     * ********************************************************
//     *
//     * @Title: get
//     * @Description: 普通缓存获取
//     * @Param: key 键
//     * @Return: Object 值
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public Object get(String key) {
//        return key == null ? null : redisTemplate.opsForValue().get(key);
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: set
//     * @Description: 普通缓存放入
//     * @Param: key 键
//     * @Param: value 值
//     * @Return: boolean true成功 false失败
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean set(String key, Object value) {
//        try {
//            redisTemplate.opsForValue().set(key, value);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("string类型的存值异常key=" + key, e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: set
//     * @Description: 普通缓存放入并设置时间
//     * @Param: key 键
//     * @Param: value  值
//     * @Param: time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
//     * @Return: boolean true成功 false 失败
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean set(String key, Object value, long time) {
//        try {
//            if (time > 0) {
//                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
//            } else {
//                set(key, value);
//            }
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("string类型缓存放入并设置时间设置异常key=" + key, e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: incr
//     * @Description: 递增
//     * @Param: key 键
//     * @Param: delta 要增加几(大于0)
//     * @Return: long
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public long incr(String key, long delta) {
//        if (delta < 0) {
//            throw new RuntimeException("递增因子必须大于0");
//        }
//        return redisTemplate.opsForValue().increment(key, delta);
//
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: decr
//     * @Description: 递减
//     * @Param: key 键
//     * @Param delta 要减少几(小于0)
//     * @Return: long
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public long decr(String key, long delta) {
//        if (delta < 0) {
//            throw new RuntimeException("递减因子必须大于0");
//        }
//        return redisTemplate.opsForValue().increment(key, -delta);
//
//    }
//    /******************************************String结束***********************************/
//
//    /******************************************hash开始*************************************/
//    /**
//     * ********************************************************
//     *
//     * @Title: hget
//     * @Description: 获取hash的值
//     * @Param: key 键相当于数据库中的表名
//     * @Param: item 项 可以使多个 不能为null
//     * @Return: Object
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public Object hget(String key, String item) {
//        try {
//            return redisTemplate.opsForHash().get(key, item);
//        } catch (Exception e) {
//            LOGGER.error("查询缓存异常：key = " + key, e);
//            return null;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hmget
//     * @Description: 获取hashKey对应的所有键值
//     * @Param: key 键
//     * @Return: Map<Object       ,       Object> 对应的多个键值
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public Map<Object, Object> hmget(String key) {
//        return redisTemplate.opsForHash().entries(key);
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hmset
//     * @Description: 向缓存中写入数据
//     * @Param: key 键
//     * @Param: map 对应多个键值
//     * @Return: boolean true成功 false失败
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean hmset(String key, Map<String, Object> map) {
//        try {
//            redisTemplate.opsForHash().putAll(key, map);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("向一张hash表中放入数据发生异常、参数为：key = " + key + "\t" + JSONObject.toJSONString(map), e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hmset
//     * @Description: 向缓存中写入数据 并设置时间
//     * @Param: key 键
//     * @Param: map 对应多个键值
//     * @Param: time 时间(秒)
//     * @Return: boolean true成功 false失败
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean hmset(String key, Map<String, Object> map, long time) {
//        try {
//            redisTemplate.opsForHash().putAll(key, map);
//            if (time > 0) {
//                expire(key, time);
//            }
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("向一张hash表中放入数据发生异常、参数为：key = " + key + "\t" + JSONObject.toJSONString(map), e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hset
//     * @Description: 向一张hash表中放入数据, 如果不存在将创建
//     * @Param: key 键
//     * @Param: item 项 可以使多个 不能为null
//     * @Param: value 值
//     * @Return: boolean 成功 false失败
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean hset(String key, String item, Object value) {
//        try {
//            redisTemplate.opsForHash().put(key, item, value);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("向一张hash表中放入数据发生异常、参数为：key = " + key + "\t" + JSONObject.toJSONString(value), e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hset
//     * @Description: 向一张hash表中放入数据, 如果不存在将创建
//     * @Param: key
//     * @Param: item 项 可以使多个 不能为null
//     * @Param: value
//     * @Param: time 时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
//     * @Return: boolean true 成功 false失败
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean hset(String key, String item, Object value, long time) {
//        try {
//            redisTemplate.opsForHash().put(key, item, value);
//            if (time > 0) {
//                expire(key, time);
//            }
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("向一张hash表中放入数据发生异常、参数为：" + JSONObject.toJSONString(value), e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hdel
//     * @Description: 删除hash表中的值
//     * @Param: key 键 不能为null
//     * @Param: item 项 可以使多个 不能为null
//     * @Return: void
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public void hdel(String key, Object... item) {
//        redisTemplate.opsForHash().delete(key, item);
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hClearCathByItem
//     * @Description: 后台线程清除hash中指定key的item
//     * @Param: keyIterm map类型的参数 key是缓存的key value是缓存的item（注意如果item是多值使用逗号分隔）
//     * @Return: void
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public void hClearCathByItem(Map<String, String> keyItem) {
//        try {
//            for (Entry<String, String> enty : keyItem.entrySet()) {
//                String key = enty.getKey();
//                String iterm = enty.getValue();
//                hdel(key, iterm);
//            }
//        } catch (Exception e) {
//            LOGGER.error("清除缓存发生异常、参数为：" + JSONObject.toJSONString(keyItem), e);
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hClearCathAllItem
//     * @Description: 清除指定key中的所有项的缓存
//     * @Param: keys hash的集合
//     * @Return: void
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public void hClearCathAllItem(List<String> keys) {
//        try {
//            redisTemplate.delete(keys);
//        } catch (Exception e) {
//            LOGGER.error("清除缓存发生异常、参数为：" + JSONObject.toJSONString(keys), e);
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hHasKey
//     * @Description: 判断hash表中是否有该项的值
//     * @Param: key 键 不能为null
//     * @Param: item 项 不能为null
//     * @Return: boolean
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean hHasKey(String key, String item) {
//        return redisTemplate.opsForHash().hasKey(key, item);
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hincr
//     * @Description: hash递增 如果不存在,就会创建一个 并把新增后的值返回
//     * @Param: key 键
//     * @Param: item 项
//     * @Param: by 要增加几(大于0)
//     * @Return: double
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public double hincr(String key, String item, double by) {
//        return redisTemplate.opsForHash().increment(key, item, by);
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: hdecr
//     * @Description: hash递减
//     * @Param: key 键
//     * @Param: item 项
//     * @Param: by 要减少记(小于0)
//     * @Return: double
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public double hdecr(String key, String item, double by) {
//        return redisTemplate.opsForHash().increment(key, item, -by);
//    }
//    /******************************************hash结束*************************************/
//
//    /******************************************set开始*************************************/
//
//    /**
//     * ********************************************************
//     *
//     * @Title: sGet
//     * @Description: 根据key获取Set中的所有值
//     * @Param: key 键
//     * @Return: Set<Object>
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public Set<Object> sGet(String key) {
//        try {
//            return redisTemplate.opsForSet().members(key);
//        } catch (Exception e) {
//            LOGGER.error("根据key获取Set中的所有值key=" + key, e);
//            return null;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: sHasKey
//     * @Description: 根据value从一个set中查询, 是否存在
//     * @Param: key 键
//     * @Param: value 值
//     * @Return: boolean true存在  false不存在
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean sHasKey(String key, Object value) {
//        try {
//            return redisTemplate.opsForSet().isMember(key, value);
//        } catch (Exception e) {
//            LOGGER.error("根据value从一个set中查询,是否存在异常key=" + key, e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: sSet
//     * @Description: 将数据放入set缓存
//     * @Param: key 键
//     * @Param: values 值 可以是多个
//     * @Return: long
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public long sSet(String key, Object... values) {
//        try {
//            return redisTemplate.opsForSet().add(key, values);
//        } catch (Exception e) {
//            LOGGER.error("将数据放入set缓存异常key=" + key, e);
//            return 0;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: sSetAndTime
//     * @Description: 将set数据放入缓存
//     * @Param: key 键
//     * @Param: time 时间(秒)
//     * @Param: values 值 可以是多个
//     * @Return: long 成功个数
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public long sSetAndTime(String key, long time, Object... values) {
//        try {
//            Long count = redisTemplate.opsForSet().add(key, values);
//            if (time > 0)
//                expire(key, time);
//            return count;
//        } catch (Exception e) {
//            LOGGER.error("将set数据放入缓存 异常key=" + key, e);
//            return 0;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: sGetSetSize
//     * @Description: 获取set缓存的长度
//     * @Param: key 键
//     * @Return: long 长度
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public long sGetSetSize(String key) {
//        try {
//            return redisTemplate.opsForSet().size(key);
//        } catch (Exception e) {
//            LOGGER.error("获取set缓存的长度异常key=" + key, e);
//            return 0;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: setRemove
//     * @Description: 移除值为value的
//     * @Param: key 键
//     * @Param: values 值 可以是多个
//     * @Return: long 移除的个数
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public long setRemove(String key, Object... values) {
//        try {
//            Long count = redisTemplate.opsForSet().remove(key, values);
//            return count;
//        } catch (Exception e) {
//            return 0;
//        }
//    }
//    /******************************************set结束*************************************/
//
//    /******************************************listl开始*************************************/
//
//    /**
//     * ********************************************************
//     *
//     * @Title: lGet
//     * @Description: 获取list缓存的内容
//     * @Param: key 键
//     * @Param: start 开始
//     * @Param: end 结束 0 到 -1代表所有值
//     * @Return: List<Object>
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public List<Object> lGet(String key, long start, long end) {
//        try {
//            return redisTemplate.opsForList().range(key, start, end);
//        } catch (Exception e) {
//            LOGGER.error("获取list缓存的内容异常key=" + key, e);
//            return null;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: lGetListSize
//     * @Description: 获取list缓存的长度
//     * @Param: key 键
//     * @Return: long
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public long lGetListSize(String key) {
//        try {
//            return redisTemplate.opsForList().size(key);
//        } catch (Exception e) {
//            LOGGER.error("获取list缓存的长度 异常key=" + key, e);
//            return 0;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: lGetIndex
//     * @Description: 通过索引 获取list中的值
//     * @Param: key 键
//     * @Param: index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
//     * @Return: Object
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public Object lGetIndex(String key, long index) {
//        try {
//            return redisTemplate.opsForList().index(key, index);
//        } catch (Exception e) {
//            LOGGER.error("通过索引 获取list中的值异常key=" + key, e);
//            return null;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: lSet
//     * @Description: 将list放入缓存
//     * @Param: key 键
//     * @Param: value 值
//     * @Return: boolean
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean lSet(String key, Object value) {
//        try {
//            redisTemplate.opsForList().rightPush(key, value);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("将list放入缓存异常key=" + key, e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: lSet
//     * @Description: 将list放入缓存
//     * @Param: key 键
//     * @Param: value 键
//     * @Param: time 时间(秒)
//     * @Return: boolean
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean lSet(String key, Object value, long time) {
//        try {
//            redisTemplate.opsForList().rightPush(key, value);
//            if (time > 0)
//                expire(key, time);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("将list放入缓存异常key=" + key, e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: lSet
//     * @Description: 将list放入缓存
//     * @Param: key 键
//     * @Param: value 值
//     * @Return: boolean
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean lSet(String key, List<Object> value) {
//        try {
//            redisTemplate.opsForList().rightPushAll(key, value);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: lSet
//     * @Description: 将list放入缓存
//     * @Param: key 键
//     * @Param: value 值
//     * @Param: time 时间(秒)
//     * @Return: boolean
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean lSet(String key, List<Object> value, long time) {
//        try {
//            redisTemplate.opsForList().rightPushAll(key, value);
//            if (time > 0)
//                expire(key, time);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("将list放入缓存异常key=" + key, e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: lUpdateIndex
//     * @Description: 根据索引修改list中的某条数据
//     * @Param: key 键
//     * @Param: index 索引
//     * @Param: value 值
//     * @Return: boolean
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public boolean lUpdateIndex(String key, long index, Object value) {
//        try {
//            redisTemplate.opsForList().set(key, index, value);
//            return true;
//        } catch (Exception e) {
//            LOGGER.error("根据索引修改list中的某条数据异常key=" + key, e);
//            return false;
//        }
//    }
//
//    /**
//     * ********************************************************
//     *
//     * @Title: lRemove
//     * @Description: 移除N个值为value
//     * @Param: key 键
//     * @Param: count 移除多少个
//     * @Param: value 值
//     * @Return: long 移除的个数
//     * @Author maojianyun
//     * *********************************************************
//     */
//    public long lRemove(String key, long count, Object value) {
//        try {
//            Long remove = redisTemplate.opsForList().remove(key, count, value);
//            return remove;
//        } catch (Exception e) {
//            LOGGER.error("移除N个值为value异常key=" + key, e);
//            return 0;
//        }
//    }
//    /******************************************listl结束*************************************/
//}
