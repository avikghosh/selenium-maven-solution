package quickfuse.core;

import java.util.HashMap;

public class TestGlobals {

    public static String chromedriverPath;
    private static HashMap<String, Integer> modules;
    public static String ssPath;
    public static int moduleCounter;
    public static int ssStepCounter;

    public static void addToModules(String moduleName) {
        if(modules == null) {
            modules = new HashMap<>();
        }
        modules.put(moduleName, moduleCounter++);
        }
    public static int getModuleId(String moduleName) {
        return modules.get(moduleName);
    }

    public static void clearModules() {
        if(modules!= null && modules.size()!=0)
            modules.clear();
    }
}
