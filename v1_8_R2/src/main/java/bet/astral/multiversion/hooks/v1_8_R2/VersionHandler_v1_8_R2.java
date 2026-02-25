package bet.astral.multiversion.hooks.v1_8_R2;

import bet.astral.multiversion.Version;
import bet.astral.multiversion.VersionHandler;

@Version(
	internalVersion = "v1_8_R2",
	legacyVersion = "v1_8_R2",
	maximumVersion = "1.8.3",
	miniumVersion = "1.8.3",
	legacy = true
)
public class VersionHandler_v1_8_R2 implements VersionHandler {
	@Override
	public void initialize() {
	}
}
