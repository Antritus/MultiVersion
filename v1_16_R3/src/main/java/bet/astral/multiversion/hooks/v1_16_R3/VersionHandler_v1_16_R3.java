package bet.astral.multiversion.hooks.v1_16_R3;

import bet.astral.multiversion.Version;
import bet.astral.multiversion.VersionHandler;

@Version(
	internalVersion = "v1_16_R3",
	legacyVersion = "v1_16_R3",
	maximumVersion = "1.16.4",
	miniumVersion = "1.16.5",
	legacy = true
)
public class VersionHandler_v1_16_R3 implements VersionHandler {
	@Override
	public void initialize() {
	}
}
