package bet.astral.aura;

import bet.astral.multiversion.Version;
import bet.astral.multiversion.VersionFetcher;
import bet.astral.multiversion.VersionHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Plugin extends JavaPlugin implements Listener {
	private VersionHandler versionHandler = null;

	public Plugin() {
	}

	@Override
	public void onLoad() {
	}

	public void sendVersion(@NotNull CommandSender sender) {
		Version version = versionHandler.getVersion();
		sender.sendMessage("---- Server ----");
		sendInfo(sender, "Minecraft Version", Bukkit.getMinecraftVersion());
		sendInfo(sender, "Bukkit Version", Bukkit.getBukkitVersion());
		sender.sendMessage("---- Aura Provider ----");
		sendInfo(sender, "Minium Version", version.miniumVersion());
		sendInfo(sender, "Maximum Version", version.maximumVersion());
		sendInfo(sender, "Internal Version", version.internalVersion());
		sendInfo(sender, "Legacy", String.valueOf(version.legacy()));
		sendInfo(sender, "Legacy Version", version.legacyVersion());

		sender.sendMessage("---- Author(s) ----");
		this.getPluginMeta().getAuthors().forEach(author->{
			sender.sendMessage(" - " + author);
		});
	}
	public void sendInfo(@NotNull CommandSender sender, String name, String value){
		sender.sendMessage(name+": " + value);
	}


	@Override
	public void onEnable() {
		versionHandler = VersionFetcher.fetch("bet.astral.multiversion.hooks");
		if (versionHandler == null) {
			getLogger().severe("");
			getLogger().severe(getName() + "("+getPluginMeta().getVersion()+") does not support the server version! (" + Bukkit.getMinecraftVersion()+")");
			getLogger().severe("");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}

		getServer().getCommandMap().register("multiversion",
			new Command("version") {
				@Override
				public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String @NotNull [] args) {
					sendVersion(sender);
					return true;
				}
			});

		getLogger().info(getName() + "("+getPluginMeta().getVersion()+") has enabled!");
	}
	@Override
	public void onDisable() {
	}
}
