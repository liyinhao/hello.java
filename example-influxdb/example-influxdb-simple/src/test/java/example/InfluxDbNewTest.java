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
public class InfluxDbNewTest {

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
        heartbeatType.add("宕机告警");
        heartbeatType.add("http连接池告警");
        heartbeatType.add("linux文件句柄数告警");
        heartbeatType.add("磁盘告警");
        heartbeatType.add("内存告警");
        heartbeatType.add("cpu利用率告警");
        heartbeatType.add("长时间FullGc告警");


        List<String> appIds = new ArrayList<>();
        appIds.add("10001-Cat");
        appIds.add("20001-消金登陆服务");
        appIds.add("40001-汽融XX服务");
        appIds.add("50001-网金XX服务");
        appIds.add("60001-XXX服务");
        appIds.add("70001-YYY服务");
        appIds.add("80001-AAA服务");
        appIds.add("90001-ZZZ服务");

        List<String> levels = new ArrayList<>();
        levels.add("error");
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

        List<String> appLevels = new ArrayList<>();
        appLevels.add("A");
        appLevels.add("B");
        appLevels.add("C");

        List<String> appTypes = new ArrayList<>();
        appTypes.add("CDN");
        appTypes.add("前端");
        appTypes.add("网关");
        appTypes.add("应用");
        appTypes.add("基础资源类");

        List<String> alertTypes = new ArrayList<>();
        alertTypes.add("DB");
        alertTypes.add("Redis");
        alertTypes.add("MongoDb");
        alertTypes.add("Network");
        alertTypes.add("系统严重异常");

        List<String> appIds = new ArrayList<>();
        appIds.add("10001-Cat");
        appIds.add("20001-消金登陆服务");
        appIds.add("40001-汽融XX服务");
        appIds.add("50001-网金XX服务");
        appIds.add("60001-XXX服务");
        appIds.add("70001-YYY服务");
        appIds.add("80001-AAA服务");
        appIds.add("90001-ZZZ服务");

        List<String> levels = new ArrayList<>();
        levels.add("error");
        levels.add("error");

        String metricName = "cat.alert";

        Random random = new Random();
        while (true) {
            String appLevel = appLevels.get(random.nextInt(appLevels.size()));
            String alertType = alertTypes.get(random.nextInt(alertTypes.size()));
            String appId = appIds.get(random.nextInt(appIds.size()));
            String alertLevel = levels.get(random.nextInt(levels.size()));

            Map<String, String> tags = new HashMap<>();
            tags.put("appLevel", appLevel);
            tags.put("type", alertType);
            tags.put("appId", appId);
            tags.put("level", alertLevel);

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
