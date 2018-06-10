package example.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by xiecheng on 17/8/18.
 */
public class StandaloneZkClient {


    private ZooKeeper zooKeeper = new ZooKeeper("", 3000, new Watcher() {
        public void process(WatchedEvent watchedEvent) {

        }
    });

    public StandaloneZkClient() throws IOException {
    }
}
