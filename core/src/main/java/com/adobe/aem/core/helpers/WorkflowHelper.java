package com.adobe.aem.core.helpers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.adobe.granite.workflow.metadata.MetaDataMap;

public class WorkflowHelper {

    private static String PROCESS_ARGS = "PROCESS_ARGS";

    public static Map<String, String> parseProcessArgs(MetaDataMap map) {
        if (map == null || map.isEmpty()) {
            return new HashMap();
        }

        String processArgs = map.get(PROCESS_ARGS, String.class);

        if (processArgs == null || processArgs.isEmpty()) {
            return new HashMap(); 
        }

        String[] args = processArgs.split(",");
        Map<String, String> result = new LinkedHashMap<>();
        for (int i = 0; i < args.length; i++) {
            String[] input = args[i].split("=");
            result.put(input[0], input[1]);
        }

        return result;
    }
    
}
