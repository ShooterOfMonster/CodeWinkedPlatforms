package com.at.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {

    // 两次检查，外加一个锁，这就是双检锁的得名，其原因是为了避免多线程同时初始化meta对象，造成资源浪费
    // 此时用volatile关键字修饰meta变量，保证了线程间的可见性，避免了线程间的同步问题
    private static volatile Meta meta;

    private MetaManager() {
        // 私有构造函数，防止外部实例化
    }

    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                // 此处使用锁的原因是，如果多个线程同时进入该方法，只有一个线程能成功初始化meta对象，其他线程则需要等待
                // 第一次初始化meta对象时，会读取meta.json文件，并解析成Meta对象，此后该对象会被缓存，后续的线程直接使用缓存的对象
                if (meta == null) {
                    meta = initMeta();
                }
                // 这里已经判断了meta是否为null，那么这个锁外边的if(meta == null)可以删除掉吗？
                // 答案是：不能，因为如果meta为null，说明meta.json文件读取失败，此时需要抛出异常，让调用者知道
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        Meta.FileConfig fileConfig = newMeta.getFileConfig();
        // todo 校验和处理默认值
        return newMeta;
    }
}
