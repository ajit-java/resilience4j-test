package resilience4j.test;
import io.micrometer.core.instrument.binder.jvm.*;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

public class DefaultMeterRegistry extends PrometheusMeterRegistry {

    public DefaultMeterRegistry() {
        super(PrometheusConfig.DEFAULT);

        config().commonTags("app", "reporting-app");
        config().commonTags("application", "reporting-app");

        // new JvmGcMetrics().bindTo(this);
        // new JvmThreadMetrics().bindTo(this);
        // new JvmMemoryMetrics().bindTo(this);
         new ClassLoaderMetrics().bindTo(this);

    }

}