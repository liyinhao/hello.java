package example;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by liyinhao on 19/3/26.
 */
public class InfluxDbTest {

    private static String url = "http://127.0.0.1:8086";

    private InfluxDB influxDB;

    private String database = "catalert";

    @Before
    public void setUp() {
        influxDB = InfluxDBFactory.connect(url).setDatabase(database);
    }

    @After
    public void setDown() {
        influxDB.close();
    }

    @Test
    public void testAlertHeartbeat() throws Exception{
        List<String> heartbeatType = new ArrayList<>();
        heartbeatType.add("catThread");
        heartbeatType.add("httpThread");
        heartbeatType.add("dubboThread");

        List<String> appIds = new ArrayList<>();
        appIds.add("11001");
        appIds.add("22001");
        appIds.add("33001");
        appIds.add("44001");
        appIds.add("55001");
        appIds.add("66001");
        appIds.add("77001");
        appIds.add("88001");
        appIds.add("99001");

        List<String> levels = new ArrayList<>();
        levels.add("warning");
        levels.add("error");

        String metricName = "cat.alert.heartbeat";

        Random random = new Random();
        while (true) {

            Map<String, String> tags = new HashMap<>();

            String type = heartbeatType.get(random.nextInt(heartbeatType.size()));
            tags.put("type", type);

            String appId = appIds.get(random.nextInt(appIds.size()));
            tags.put("appId", appId);

            String level = levels.get(random.nextInt(levels.size()));
            tags.put("level", level);

            addMetrics(database, metricName, tags, 1);

            System.out.println("sleeping");
            TimeUnit.MILLISECONDS.sleep(1000L);
        }

    }

    @Test
    public void testAlert() throws Exception {
        List<String> alertTypes = new ArrayList<>();
        alertTypes.add("transaction");
        alertTypes.add("event");
        alertTypes.add("exception");
        alertTypes.add("heartbeat");

        List<String> appIds = new ArrayList<>();
        appIds.add("10001");
        appIds.add("20001");
        appIds.add("30001");
        appIds.add("40001");
        appIds.add("50001");
        appIds.add("60001");
        appIds.add("70001");
        appIds.add("80001");
        appIds.add("90001");

        List<String> levels = new ArrayList<>();
        levels.add("warning");
        levels.add("error");

        String metricName = "cat.alert";

        Random random = new Random();
        while (true) {
            String type = alertTypes.get(random.nextInt(alertTypes.size()));
            String appId = appIds.get(random.nextInt(appIds.size()));
            String level = levels.get(random.nextInt(levels.size()));

            Map<String, String> tags = new HashMap<>();
            tags.put("type", type);
            tags.put("appId", appId);
            tags.put("level", level);

            addMetrics(database, metricName, tags, 1);

            System.out.println("sleeping");
            TimeUnit.MILLISECONDS.sleep(1000L);
        }
    }

    private void addMetrics(String database, String metricsName, Map<String, String> tags, double value) {
        BatchPoints batchPoints = BatchPoints.database(database).tag("async", "true")
                .retentionPolicy("autogen")
                .consistency(InfluxDB.ConsistencyLevel.ALL)
                .build();


        Point.Builder ptBuilder = Point.measurement(metricsName)
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        ptBuilder.tag(tags);
        ptBuilder.addField("value", value);

        Point pt = ptBuilder.build();
        batchPoints.point(pt);
        influxDB.write(batchPoints);
    }
}
