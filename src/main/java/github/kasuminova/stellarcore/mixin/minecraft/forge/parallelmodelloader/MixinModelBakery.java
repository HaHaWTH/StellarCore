package github.kasuminova.stellarcore.mixin.minecraft.forge.parallelmodelloader;

import github.kasuminova.stellarcore.shaded.org.jctools.maps.NonBlockingHashMap;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelBlockDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.VariantList;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;
import java.util.Map;

@SuppressWarnings({"MethodMayBeStatic", "SynchronizeOnNonFinalField", "FieldAccessedSynchronizedAndUnsynchronized"})
@Mixin(ModelBakery.class)
public abstract class MixinModelBakery {

    @Shadow
    protected abstract ResourceLocation getBlockstateLocation(final ResourceLocation location);

    @Final
    @Shadow
    @Mutable
    private Map<ResourceLocation, ModelBlockDefinition> blockDefinitions;

    @Shadow
    protected abstract ModelBlockDefinition loadMultipartMBD(final ResourceLocation location, final ResourceLocation fileIn);

    @Final
    @Shadow
    @Mutable
    private Map<ModelResourceLocation, VariantList> variants;

    @Final
    @Shadow
    @Mutable
    private Map<ModelBlockDefinition, Collection<ModelResourceLocation>> multipartVariantMap;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void injectInit(final IResourceManager resourceManagerIn, final TextureMap textureMapIn, final BlockModelShapes blockModelShapesIn, final CallbackInfo ci) {
        blockDefinitions = new NonBlockingHashMap<>();
        variants = new NonBlockingHashMap<>();
        multipartVariantMap = new NonBlockingHashMap<>();
    }

    /**
     * @author Kasumi_Nova
     * @reason Thread Safe.
     */
    @Overwrite
    protected ModelBlockDefinition getModelBlockDefinition(ResourceLocation location) {
        ResourceLocation resourcelocation = this.getBlockstateLocation(location);
        return this.blockDefinitions.computeIfAbsent(resourcelocation, (key) -> this.loadMultipartMBD(location, resourcelocation));
    }

}
