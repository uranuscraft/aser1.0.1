package aser.plugins;

import java.util.LinkedList;

import net.minecraftforge.common.Configuration;

import java.io.File;
import java.util.*;

import cpw.mods.fml.common.Loader;
public class PluginController
{

private enum Phase {
    PRELAUNCH, PREINIT, INIT, POSTINIT, DONE
}

private static PluginController instance;
private Configuration conf = null;
private List<ICompatPlugin> plugins = new LinkedList<ICompatPlugin>();
private Phase currPhase = Phase.PRELAUNCH;

private PluginController() {
   
}

public static PluginController getController()
{
    if (instance == null) instance = new PluginController();
    return instance;
}

/**
 * Register a plugin with the controller.
 *
 * Warning: Make sure your plugin class imports no APIs directly! Any API interaction should be done by handlers called in pre/init/post so
 *          merely creating an instance to check the mod ID isn't a hazard to the controller.
 *
 * @param plugin Plugin to register
 */
public void registerPlugin(ICompatPlugin plugin)
{
    conf.load();
    boolean shouldLoad = conf.get("Plugins", plugin.getModId(), true).getBoolean(true);
    conf.save();

    if (shouldLoad)
        loadPlugin(plugin);
}

// This does the actual plugin loading if mod is present; needed to allow force-enabling.
private void loadPlugin(ICompatPlugin plugin)
{
    if (!Loader.isModLoaded(plugin.getModId())) return;

   
    plugins.add(plugin);

    switch (currPhase) // Play catch-up if plugin is registered late
    {
        case DONE:
        case POSTINIT:
            plugin.preInit();
            plugin.init();
            plugin.postInit();
            break;
        case INIT:
            plugin.preInit();
            plugin.init();
            break;
        case PREINIT:
            plugin.preInit();
            break;
        default:
            break;
    }
}

public void preInit()
{
    currPhase = Phase.PREINIT;
    for (ICompatPlugin pl : plugins) pl.preInit();
}

public void init()
{
    currPhase = Phase.INIT;
    for (ICompatPlugin pl : plugins) pl.init();
}

public void postInit()
{
    currPhase = Phase.POSTINIT;
    for (ICompatPlugin pl : plugins) pl.postInit();
    currPhase = Phase.DONE;
}

public void registerBuiltins()
{
  
    
}
}