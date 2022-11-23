package entity;

import redis.clients.jedis.*;

//import java.util.Set;

public class JedisDBConnection {
    private static JedisPooled pool;
//    private JedisCluster cluster;
//    private void initDbConnection() {
//        JedisClientConfig clientConfig = DefaultJedisClientConfig.builder().password("master123").build();
//
//        Set<HostAndPort> clusterUris = Set.of(
//                new HostAndPort("localhost", 7001),
//                new HostAndPort("localhost", 7002),
//                new HostAndPort("localhost", 7003),
//                new HostAndPort("localhost", 7004),
//                new HostAndPort("localhost", 7005),
//                new HostAndPort("localhost", 7006)
//        );
//        cluster = new JedisCluster(clusterUris, clientConfig);
//    }

    public void initConnection() {
        JedisClientConfig clientConfig = DefaultJedisClientConfig.builder().build();
        pool = new JedisPooled(new HostAndPort("localhost", 6379), clientConfig);
    }

}
