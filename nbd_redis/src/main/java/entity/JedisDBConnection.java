package entity;

import redis.clients.jedis.*;


public class JedisDBConnection extends AbstractMongoRepository {
    private static JedisPooled pool;

    public void initConnection() {
        JedisClientConfig clientConfig = DefaultJedisClientConfig.builder().build();
        pool = new JedisPooled(new HostAndPort("localhost", 6379), clientConfig);
    }

}
