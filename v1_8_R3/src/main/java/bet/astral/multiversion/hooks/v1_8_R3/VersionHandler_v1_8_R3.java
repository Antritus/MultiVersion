package bet.astral.multiversion.hooks.v1_8_R3;

import bet.astral.multiversion.Version;
import bet.astral.multiversion.VersionHandler;
import org.bukkit.Bukkit;

@Version(
	internalVersion = "v1_8_R3",
	legacyVersion = "v1_8_R3",
	maximumVersion = "1.8.8",
	miniumVersion = "1.8.3",
	legacy = true
)
public class VersionHandler_v1_8_R3 implements VersionHandler {
	@Override
	public void initialize() {
	}
}
