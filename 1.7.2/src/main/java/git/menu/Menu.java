package git.menu;



@Mod(modid = "New Gui")
public class Menu
{
	@Mod.Instance("Menu")
	public static Menu instance;
	@Mod.EventHandler
	@SideOnly(Side.CLIENT)
	public void preInit(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		//读取配置文件
		ConfigVar.onlinecheck = config.get("Online", "Check", false).getBoolean();
		ConfigVar.version = config.get("Online", "Version", 1.0).getDouble();
		ConfigVar.url = config.get("Online", "Url", "http://").getString();
		ConfigVar.downloads = config.get("Online", "Downloads", "http://").getString();
		
		ConfigVar.IsTwoAddress = config.get("Server", "1sTwoAddress", false).getBoolean();
		ConfigVar.ServerAddress = config.get("Server", "Address1", "127.0.0.1").getString();
		ConfigVar.ServerAddress1 = config.get("Server", "Address2", "127.0.0.1").getString();
		ConfigVar.Captain = config.get("Server", "Captain", "Minecraft 1.7.10").getString();
		ConfigVar.announcement = config.get("Server", "Announcement", "").getString();
		//结束读取
		config.save();
		Display.setTitle(ConfigVar.Captain);
		MinecraftForge.EVENT_BUS.register(NewMenuHandler.instance);
	}
}