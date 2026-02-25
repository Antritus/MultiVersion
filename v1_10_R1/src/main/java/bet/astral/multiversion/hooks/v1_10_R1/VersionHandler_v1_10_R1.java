package bet.astral.multiversion.hooks.v1_10_R1;

import bet.astral.multiversion.Version;
import bet.astral.multiversion.VersionHandler;

@Version(
	internalVersion = "v1_10_R1",
	legacyVersion = "v1_10_R1",
	maximumVersion = "1.10.2",
	miniumVersion = "1.10",
	legacy = true
)
public class VersionHandler_v1_10_R1 implements VersionHandler {
	@Override
	public void initialize() {
	}
}
