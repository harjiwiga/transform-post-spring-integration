package id.lsa.scb.spring.integration.routers;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.*;
import org.springframework.integration.channel.NullChannel;

import java.util.List;

/**
 * Created by harji on 4/29/16.
 */

@MessageEndpoint
public class ResponseAggregator {

    private Logger logger = Logger.getLogger(ResponseAggregator.class);

    /**
     * , sendTimeout = "1000",autoStartup = "true",sendPartialResultsOnExpiry ="true",poller = @Poller("myPoller")
     *
     * @param responses
     * @return
     */
    @Aggregator(inputChannel = "nullChannel",poller = @Poller("globalPoller"))
    public void aggregate(List<NullChannel> responses) {

        logger.info("aggregate");
//        String resultCompilation = "fail";
//        List<String> returnList = new ArrayList<String>();
//        logger.info("aggreator---->");
//        String importJobid = "";
//        int sign = 0;
//        for (Message<?> r : responses) {
//            ObjectMapper mapper = new ObjectMapper();
//            HashMap<String, Object> response = (HashMap<String, Object>) r.getPayload();
//            logger.info("header:" + r.getHeaders());
//            logger.info("header:" + r.getPayload());
//            String status = String.valueOf(response.get("status"));
//            if (status.equals("success")) {
//                sign++;
//            }
//            if (r.getHeaders().get("json__TypeId__").equals(ImportJob.class)) {
//                importJobid = String.valueOf(response.get("configuration-id"));
//            }
//        }
//
//        if (sign == 3) {
//            return importJobid;
//        } else {
//            return "-1";
//        }

    }


    @CorrelationStrategy
    public Object correlateBy(NullChannel message) {
        logger.info("correlateBy------>");
        return "same";
    }

    @ReleaseStrategy
    public boolean isReadytoRelease(List<NullChannel> messages) {
        logger.info("release------>");
        return true;
    }
//
//
//
//    @Bean
//    public PollerMetadata myPoller() {
//        PollerMetadata pollerMetadata = new PollerMetadata();
//        pollerMetadata.setTrigger(new PeriodicTrigger(1000));
//        pollerMetadata.setMaxMessagesPerPoll(3);
//
//        return pollerMetadata;
//    }

}
