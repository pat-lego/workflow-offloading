package com.adobe.aem.core.workflow;

import java.util.Map;

import com.adobe.aem.core.helpers.WorkflowHelper;
import com.adobe.granite.ui.components.Value;
import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = WorkflowProcess.class,
    property = {
        "process.label=Log A Message"
})
public class SimpleProcess implements WorkflowProcess {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static String Message = "Message";

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metadataMap) throws WorkflowException {
        Map<String, String> params = WorkflowHelper.parseProcessArgs(metadataMap);

        logger.info("The payload is set to {} ",workItem.getWorkflowData().getPayload().toString());
    
        if (null != params.get(Message)) {
            logger.info("The {} process has been invoked with the following message {}", this.getClass().getName(), params.get(Message));
        } else {
            logger.info("The {} process has been invoked!", this.getClass().getName());
        }

    }
    
}
