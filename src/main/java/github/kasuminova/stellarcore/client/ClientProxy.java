package github.kasuminova.stellarcore.client;

import github.kasuminova.stellarcore.client.handler.ClientEventHandler;
import github.kasuminova.stellarcore.client.pool.BakedQuadPool;
import github.kasuminova.stellarcore.client.pool.BlockFaceUVsPool;
import github.kasuminova.stellarcore.client.pool.StellarUnpackedDataPool;
import github.kasuminova.stellarcore.client.util.TitleUtils;
import github.kasuminova.stellarcore.common.CommonProxy;
import github.kasuminova.stellarcore.common.command.CommandStellarCoreClient;
import github.kasuminova.stellarcore.common.config.StellarCoreConfig;
import github.kasuminova.stellarcore.common.mod.Mods;
import github.kasuminova.stellarcore.common.util.StellarLog;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

    @Override
    public void construction() {
        super.construction();

        TitleUtils.setRandomTitle("*Construction*");
    }

    @Override
    public void preInit() {
        super.preInit();
        MinecraftForge.EVENT_BUS.register(ClientEventHandler.INSTANCE);

//        if (Mods.REPLAY.loaded() && StellarCoreConfig.PERFORMANCE.vanilla.hudCaching) {
//            StellarCoreConfig.PERFORMANCE.vanilla.hudCaching = false;
//            StellarLog.LOG.warn("Replay Mod is not compatible with Performance/HUDCaching feature, auto disabled!");
//        }

        TitleUtils.setRandomTitle("*PreInit*");
    }

    @Override
    public void init() {
        super.init();

        TitleUtils.setRandomTitle("*Init*");
    }

    @Override
    public void postInit() {
        super.postInit();

        ClientCommandHandler.instance.registerCommand(CommandStellarCoreClient.INSTANCE);

        TitleUtils.setRandomTitle("*PostInit*");
    }

    @Override
    public void loadComplete() {
        super.loadComplete();

        TitleUtils.setRandomTitle();
        StellarUnpackedDataPool.reset();
        BakedQuadPool.INSTANCE.clear();
        BlockFaceUVsPool.INSTANCE.clear();
    }

}
