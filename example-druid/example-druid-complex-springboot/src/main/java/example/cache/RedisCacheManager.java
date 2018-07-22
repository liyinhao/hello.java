package example.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Random;

/**
 * Created by liyinhao on 18/7/22.
 */
public class RedisCacheManager {

    private static JedisPoolConfig jedisPoolConfig;

    private static JedisPool[] jedisPools = new JedisPool[10];

    static {
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(1000);
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMinIdle(2);

        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);

        jedisPoolConfig.setJmxNamePrefix("predis-pool");
    }


    public static String get(String key) {
        Jedis jedis = null;

        try {
            jedis = getJedis();
            return jedis.get(key);
        } finally {
            returnResource(jedis);
        }
    }

    public static String set(String key, String value) {
        Jedis jedis = null;

        try {
            jedis = getJedis();
            return jedis.setex(key, 1000, value);
        } finally {
            returnResource(jedis);
        }
    }


    private static Jedis getJedis() {

        try {
            JedisPool jedisPool = getJedisPool();
            return jedisPool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private static void returnResource(Jedis jedis) {
        jedis.close();
    }

    private static JedisPool getJedisPool() {

        int size = jedisPools.length;

        Random random = new Random();
        int index = random.nextInt(size);

        JedisPool jedisPool = jedisPools[index];
        if (jedisPool == null) {
            jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379, 10000, null);
        }

        jedisPools[index] = jedisPool;

        return jedisPool;
    }


}
