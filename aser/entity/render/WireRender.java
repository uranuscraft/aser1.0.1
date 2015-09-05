package aser.entity.render;

import ic2.api.energy.tile.IEnergyAcceptor;
import ic2.api.energy.tile.IEnergyEmitter;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.energy.tile.IEnergyTile;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import buildcraft.api.power.IPowerReceptor;
import universalelectricity.compatibility.Compatibility;
import universalelectricity.core.block.IConnector;
import universalelectricity.core.vector.Vector3;
import universalelectricity.core.vector.VectorHelper;
import aser.core.Base;
import aser.entity.TileWire;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;
@SideOnly(Side.CLIENT)
public class WireRender extends TileEntitySpecialRenderer{
	 private static final ResourceLocation copperWireTexture = new ResourceLocation(Base.modid + ":" + "textures/model/copperWire.png");
	 private static final ResourceLocation tinWireTexture = new ResourceLocation(Base.modid + ":" + "textures/model/tinWire.png");
	 private static final ResourceLocation silverWireTexture = new ResourceLocation(Base.modid + ":" + "textures/model/silverWire.png");
	 private static final ResourceLocation hvWireTexture = new ResourceLocation(Base.modid + ":" + "textures/model/hvWire.png");
	 private static final ResourceLocation superWireTexture = new ResourceLocation(Base.modid + ":" + "textures/model/superWire.png");
	 private static ResourceLocation wire = new ResourceLocation(Base.modid + ":" + "textures/model/Wire.png");
	    public final IModelCustom model;
	    public final IModelCustom model2;
	    public final IModelCustom model3;
	    public final IModelCustom model4;
	    public final IModelCustom model5;
	    public WireRender()
	    {
	        this.model = AdvancedModelLoader.loadModel("/assets/uranuscraft_aser/models/copperWire.obj");
	        this.model2 = AdvancedModelLoader.loadModel("/assets/uranuscraft_aser/models/tinWire.obj");
	    this.model3 = AdvancedModelLoader.loadModel("/assets/uranuscraft_aser/models/silverWire.obj");
	    this.model4 = AdvancedModelLoader.loadModel("/assets/uranuscraft_aser/models/hvWire.obj");
	    this.model5 = AdvancedModelLoader.loadModel("/assets/uranuscraft_aser/models/superWire.obj");
	    
	    
	    }

	    public void renderModelAt(TileWire tileEntity, double d, double d1, double d2, float f)
	    {
	        // Texture file
	    	
	    	
	    	
	        FMLClientHandler.instance().getClient().renderEngine.bindTexture(WireRender.wire);
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float) d + 0.5F, (float) d1 + 0.5F, (float) d2 + 0.5F);
	        GL11.glScalef(1.0F, -1F, -1F);

	        List<TileEntity> adjecentConnections = new ArrayList<TileEntity>();

	        for (byte i = 0; i < 6; i++)
	        {
	            ForgeDirection side = ForgeDirection.getOrientation(i);
	            TileEntity adjacentTile = VectorHelper.getTileEntityFromSide(tileEntity.worldObj, new Vector3(tileEntity), side);

	            if (adjacentTile instanceof IConnector)
	            {
	                if (((IConnector) adjacentTile).canConnect(side.getOpposite()))
	                {
	                    adjecentConnections.add(adjacentTile);
	                }
	                else
	                {
	                    adjecentConnections.add(null);
	                }
	            }
	            else if (Compatibility.isIndustrialCraft2Loaded() && adjacentTile instanceof IEnergyTile)
	            {
	                if (adjacentTile instanceof IEnergyAcceptor)
	                {
	                    if (((IEnergyAcceptor) adjacentTile).acceptsEnergyFrom(tileEntity, side.getOpposite()))
	                    {
	                        adjecentConnections.add(adjacentTile);
	                    }
	                    else
	                    {
	                        if (adjacentTile instanceof IEnergySource && ((IEnergyEmitter) adjacentTile).emitsEnergyTo(tileEntity, side.getOpposite()))
	                        {
	                            adjecentConnections.add(adjacentTile);
	                        }
	                        else
	                        {
	                            adjecentConnections.add(null);
	                        }
	                    }
	                }
	                else
	                {
	                    adjecentConnections.add(adjacentTile);
	                }
	            }
	            else if (Compatibility.isBuildcraftLoaded() && adjacentTile instanceof IPowerReceptor)
	            {
	                adjecentConnections.add(adjacentTile);
	            }
	            else
	            {
	                adjecentConnections.add(null);
	            }
	        }

	        int metadata = tileEntity.worldObj.getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);

	        IModelCustom model = null;

	        if (metadata == 0)
	        {
	            model = this.model;
	        }
	        else if(metadata == 1)
	        {
	            model = this.model2;
	        }
	        else if(metadata == 2)
	        {
	            model = this.model3;
	        }else if(metadata == 3)
	        {
	            model = this.model4;
	        }else if(metadata == 4)
	        {
	            model = this.model5;
	        }
	        if (adjecentConnections.toArray()[0] != null)
	        {
	            model.renderPart("Top");
	        }

	        if (adjecentConnections.toArray()[1] != null)
	        {
	            model.renderPart("Bottom");
	        }

	        if (adjecentConnections.toArray()[2] != null)
	        {
	            model.renderPart("Front");
	        }

	        if (adjecentConnections.toArray()[3] != null)
	        {
	            model.renderPart("Back");
	        }

	        if (adjecentConnections.toArray()[4] != null)
	        {
	            model.renderPart("Right");
	        }

	        if (adjecentConnections.toArray()[5] != null)
	        {
	            model.renderPart("Left");
	        }

	        model.renderPart("Middle");
	        GL11.glPopMatrix();
	    }

	    @Override
	    public void renderTileEntityAt(TileEntity tileEntity, double var2, double var4, double var6, float var8)
	    {
	        this.renderModelAt((TileWire) tileEntity, var2, var4, var6, var8);
	    }
	}

