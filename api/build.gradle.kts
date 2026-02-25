plugins {
	`my-conventions`
}

repositories {
	maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
	compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
	compileOnly("org.jetbrains:annotations:24.0.0")
	implementation("io.github.classgraph:classgraph:4.8.184")
}

tasks.withType<JavaCompile>().configureEach {
	options.release.set(8)
}
