package bet.astral.multiversion.hooks.v1_16_R2;

import bet.astral.multiversion.Version;
import bet.astral.multiversion.VersionHandler;

@Version(
	internalVersion = "v1_16_R2",
	legacyVersion = "v1_16_R2",
	maximumVersion = "1.16.3",
	miniumVersion = "1.16.2",
	legacy = true
)
public class VersionHandler_v1_16_R2 implements VersionHandler {
	@Override
	public void initialize() {
	}
}
