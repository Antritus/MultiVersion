plugins {
	buildtools
	`my-conventions`
	java
}

dependencies {
	implementation(project(":api"))
	compileOnly("org.jetbrains:annotations:24.0.0")
	buildtools.bundle("1.8.8")
}

tasks.withType<JavaCompile>().configureEach {
	options.release.set(8)
}

