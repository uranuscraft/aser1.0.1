package aser.plugins;

/**
 * Interface for TiC compat plugins.
 *
 * Do not include mod API usage directly in this file except for IMC! This must be constructable even
 * when the target mod isn't available due to Java not allowing static abstracts.
 */
public interface ICompatPlugin {

    // Mod ID the plugin handles
    public abstract String getModId();

    // Called during PreInit
    public abstract void preInit();

    // Called during Init
    public abstract void init();

    // Called during PostInit
    public abstract void postInit();

}