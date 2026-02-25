package bet.astral.multiversion.hooks.v1_13_R2;


import bet.astral.multiversion.Version;
import bet.astral.multiversion.VersionHandler;

@Version(
	internalVersion = "v1_13_R2",
	legacyVersion = "v1_13_R2",
	maximumVersion = "1.13.2",
	miniumVersion = "1.13.1",
	legacy = true
)
public class VersionHandler_v1_13_R2 implements VersionHandler {
	@Override
	public void initialize() {
	}
}
