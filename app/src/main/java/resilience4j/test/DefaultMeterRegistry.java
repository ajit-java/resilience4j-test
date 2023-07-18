package resilience4j.test;
import io.micrometer.core.instrument.binder.jvm.*;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

public class DefaultMeterRegistry extends PrometheusMeterRegistry {

    public DefaultMeterRegistry() {
        super(PrometheusConfig.DEFAULT);

        config().commonTags("app", "realtime-reporting");
        config().commonTags("application", "realtime-reporting");

        new JvmGcMetrics().bindTo(this);
        new JvmThreadMetrics().bindTo(this);
        new JvmMemoryMetrics().bindTo(this);
        new ClassLoaderMetrics().bindTo(this);

    }

}