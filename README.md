# Sample AEM project template

This is a project template for AEM-based applications. It is intended as a best-practice set of examples as well as a potential starting point to develop your own functionality.

## Content

This repository contains two workflows 

1. Invoked Model which is the model that gets invoked (Child Workflow)
2. Invoker Model which is the model that invokes the invoked worklow (Parent Workflow)

The project once installed will place the workflows in your repository were then you can invoke the `Invoked Workflow` make sure that the `workflow-offloading.core` bundle is installed and active.

Lastly once you trigger the parent workflow you should see the following messages in your log file:

```
06.04.2022 10:30:57.132 *INFO* [JobHandler: /var/workflow/instances/server0/2022-04-06/invoker-model_7:/apps] com.adobe.aem.core.workflow.SimpleProcess The payload is set to /apps 
06.04.2022 10:30:57.133 *INFO* [JobHandler: /var/workflow/instances/server0/2022-04-06/invoker-model_7:/apps] com.adobe.aem.core.workflow.SimpleProcess The com.adobe.aem.core.workflow.SimpleProcess process has been invoked with the following message About to trigger the workflow 
06.04.2022 10:30:57.169 *INFO* [JobHandler: /var/workflow/instances/server0/2022-04-06/invoked-model_8:/apps] com.adobe.aem.core.workflow.SimpleProcess The payload is set to /apps 
06.04.2022 10:30:57.169 *INFO* [JobHandler: /var/workflow/instances/server0/2022-04-06/invoked-model_8:/apps] com.adobe.aem.core.workflow.SimpleProcess The com.adobe.aem.core.workflow.SimpleProcess process has been invoked with the following message I am getting invoked
06.04.2022 10:30:57.204 *INFO* [JobHandler: /var/workflow/instances/server0/2022-04-06/invoker-model_7:/apps] com.adobe.aem.core.workflow.SimpleProcess The payload is set to /apps 
06.04.2022 10:30:57.204 *INFO* [JobHandler: /var/workflow/instances/server0/2022-04-06/invoker-model_7:/apps] com.adobe.aem.core.workflow.SimpleProcess The com.adobe.aem.core.workflow.SimpleProcess process has been invoked with the following message The workflow is now complete
```

## Command Used

mvn -B org.apache.maven.plugins:maven-archetype-plugin:3.2.1:generate \
 -D archetypeGroupId=com.adobe.aem \
 -D archetypeArtifactId=aem-project-archetype \
 -D archetypeVersion=36\
 -D appTitle="Workflow Offloading" \
 -D appId="offloading" \
 -D groupId="com.adobe.aem" \
 -D artifactId="workflow-offloading" \
 -D aemVersion="6.5.12"