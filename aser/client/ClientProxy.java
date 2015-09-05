package aser.client;

import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import aser.block.BlockLoader;
import aser.core.Base;
import aser.core.CommonProxy;
import aser.entity.OpLaser;
import aser.entity.TileWire;
import aser.entity.render.MachineRender;
import aser.entity.render.WireRender;


public class ClientProxy extends CommonProxy {
	public static int Wire_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
	private static int renderIdMachine;
	
	@Override
    public void registerRenderers() {
            // This is for rendering entities and so forth later on
    	 ClientRegistry.bindTileEntitySpecialRenderer(TileWire.class, new WireRender());
    	 RenderingRegistry.registerBlockHandler(new MachineRender(ClientProxy.renderIdMachine));
    	 String vill = Base.modid + ":" + "santa.png";
    	 VillagerRegistry.instance().registerVillagerSkin(7194, new ResourceLocation(vill));
         
    	   
	
	}
    @Override
    public int getBlockRenderID(int blockID)
    {
      
         if (blockID == BlockLoader.TransformerBase.blockID)
        {
            return ClientProxy.renderIdMachine;
        }

        return -1;
    }
}
