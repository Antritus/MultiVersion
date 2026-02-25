plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
}

gradlePlugin {
	plugins {
		create("buildToolsPlugin") {
			id = "bet.astral.multiversion.buildtools"
			implementationClass = "BuildToolsPlugin"
		}
	}
}
