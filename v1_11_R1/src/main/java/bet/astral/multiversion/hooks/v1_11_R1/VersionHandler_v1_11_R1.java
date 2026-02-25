package bet.astral.multiversion.hooks.v1_11_R1;

import bet.astral.multiversion.Version;
import bet.astral.multiversion.VersionHandler;

@Version(
	internalVersion = "v1_11_R1",
	legacyVersion = "v1_11_R1",
	maximumVersion = "1.11.2",
	miniumVersion = "1.11",
	legacy = true
)
public class VersionHandler_v1_11_R1 implements VersionHandler {
	@Override
	public void initialize() {
	}
}
