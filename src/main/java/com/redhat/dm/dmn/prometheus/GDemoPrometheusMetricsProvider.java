package com.redhat.dm.dmn.prometheus;

import org.jbpm.executor.AsynchronousJobListener;
import org.jbpm.services.api.DeploymentEventListener;
import org.kie.api.builder.ReleaseId;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.dmn.api.core.event.DMNRuntimeEventListener;
import org.kie.server.services.api.KieContainerInstance;
import org.kie.server.services.prometheus.PrometheusMetricsProvider;
import org.optaplanner.core.impl.phase.event.PhaseLifecycleListener;

/**
 * GDemoPrometheusMetricsProvider
 */
public class GDemoPrometheusMetricsProvider implements PrometheusMetricsProvider {

    @Override
    public AgendaEventListener createAgendaEventListener(String arg0, KieContainerInstance arg1) {
        return null;
    }

    @Override
    public AsynchronousJobListener createAsynchronousJobListener() {
        return null;
    }

    @Override
    public DMNRuntimeEventListener createDMNRuntimeEventListener(KieContainerInstance kci) {
        // Use GroupId, ArtifactId and Version as labels.
        ReleaseId releaseId = kci.getKieContainer().getReleaseId();
        return new PrometheusMetricsKieServerGDListener(releaseId.getGroupId(), releaseId.getArtifactId(), releaseId.getVersion());
    }

    @Override
    public DeploymentEventListener createDeploymentEventListener() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PhaseLifecycleListener createPhaseLifecycleListener(String arg0) {
        // TODO Auto-generated method stub
        return null;
    }

}