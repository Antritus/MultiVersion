plugins {
	`my-conventions`
	java
}

dependencies {
	implementation(project(":api"))
	compileOnly("org.jetbrains:annotations:24.0.0")

	compileOnly(files("../libs/spigot-1.16.1.jar"))
}

tasks.withType<JavaCompile>().configureEach {
	options.release.set(8)
}
