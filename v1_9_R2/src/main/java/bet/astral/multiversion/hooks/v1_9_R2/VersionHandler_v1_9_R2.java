package bet.astral.multiversion.hooks.v1_9_R2;

import bet.astral.multiversion.Version;
import bet.astral.multiversion.VersionHandler;

@Version(
	internalVersion = "v1_9_R2",
	legacyVersion = "v1_9_R2",
	maximumVersion = "1.9.4",
	miniumVersion = "1.9.3",
	legacy = true
)
public class VersionHandler_v1_9_R2 implements VersionHandler {
	@Override
	public void initialize() {
	}
}
