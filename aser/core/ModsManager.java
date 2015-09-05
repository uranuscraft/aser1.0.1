package aser.core;

import cpw.mods.fml.common.Loader;

public class ModsManager {
	 private static boolean modIc2Loaded;
	    private static boolean modBCraftLoaded;
	    private static boolean modGTLoaded;
	    private static boolean modTELoaded;
	    private static boolean modAetherIILoaded;
	    private static boolean modBasicComponentsLoaded;
	    private static boolean modAppEngLoaded;

	    public static void checkForCompatibleMods()
	    {
	        if (Loader.isModLoaded("GregTech_Addon"))
	        {
	        	ModsManager.modGTLoaded = true;
	        }

	        if (Loader.isModLoaded("ThermalExpansion"))
	        {
	        	ModsManager.modTELoaded = true;
	        }

	        if (Loader.isModLoaded("IC2"))
	        {
	        	ModsManager.modIc2Loaded = true;
	        }

	        if (Loader.isModLoaded("BuildCraft|Core"))
	        {
	        	ModsManager.modBCraftLoaded = true;
	        }

	        if (Loader.isModLoaded("Aether II"))
	        {
	        	ModsManager.modAetherIILoaded = true;
	        }

	        if (Loader.isModLoaded("BasicComponents"))
	        {
	        	ModsManager.modBasicComponentsLoaded = true;
	        }

	        if (Loader.isModLoaded("AppliedEnergistics"))
	        {
	        	ModsManager.modAppEngLoaded = true;
	        }
	    }

	    public static boolean isIc2Loaded()
	    {
	        return ModsManager.modIc2Loaded;
	    }

	    public static boolean isBCraftLoaded()
	    {
	        return ModsManager.modBCraftLoaded;
	    }

	    public static boolean isTELoaded()
	    {
	        return ModsManager.modTELoaded;
	    }

	    public static boolean isGTLoaded()
	    {
	        return ModsManager.modGTLoaded;
	    }

	    public static boolean isAIILoaded()
	    {
	        return ModsManager.modAetherIILoaded;
	    }

	    public static boolean isBCLoaded()
	    {
	        return ModsManager.modBasicComponentsLoaded;
	    }

	    public static boolean isAppEngLoaded()
	    {
	        return ModsManager.modAppEngLoaded;
	    }
	}

