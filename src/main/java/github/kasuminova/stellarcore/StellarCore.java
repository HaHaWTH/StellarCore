package github.kasuminova.stellarcore;

import github.kasuminova.stellarcore.client.hitokoto.HitokotoAPI;
import github.kasuminova.stellarcore.common.CommonProxy;
import github.kasuminova.stellarcore.common.command.CommandStellarCore;
import github.kasuminova.stellarcore.common.config.StellarCoreConfig;
import github.kasuminova.stellarcore.common.util.StellarLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.Logger;

@Mod(modid = StellarCore.MOD_ID, name = StellarCore.MOD_NAME, version = StellarCore.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);" +
                "required-after:configanytime@[2.0,);" +
                "required-after:mixinbooter@[8.0,);" +
                "after:jei;",
        acceptedMinecraftVersions = "[1.12, 1.13)",
        acceptableRemoteVersions = "*"
)
@SuppressWarnings("MethodMayBeStatic")
public class StellarCore {
    public static final String MOD_ID = "stellar_core";
    public static final String MOD_NAME = "Stellar Core";

    public static final String VERSION = Tags.VERSION;

    public static final String CLIENT_PROXY = "github.kasuminova.stellarcore.client.ClientProxy";
    public static final String COMMON_PROXY = "github.kasuminova.stellarcore.common.CommonProxy";

    @Mod.Instance(MOD_ID)
    public static StellarCore instance = null;
    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static CommonProxy proxy = null;
    public static Logger log = null;

    static {
        if (StellarCoreConfig.FEATURES.hitokoto) {
            Thread thread = new Thread(() -> {
                String hitokoto = HitokotoAPI.getRandomHitokoto();
                if (hitokoto == null || hitokoto.isEmpty()) {
                    return;
                }
                StellarLog.LOG.info(StellarLog.LOG_PREFIX + hitokoto);
            });
            thread.setName("Stellar Core Hitokoto Initializer");
            thread.start();
        }
    }

    @Mod.EventHandler
    public void construction(FMLConstructionEvent event) {
        proxy.construction();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        event.getModMetadata().version = VERSION;
        log = event.getModLog();
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        proxy.loadComplete();
    }

    @Mod.EventHandler
    public void onServerStart(FMLServerStartingEvent event) {
        event.registerServerCommand(CommandStellarCore.INSTANCE);
    }

}
