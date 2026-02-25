import bet.astral.multiversion.buildtools.RunBuildToolsTask
import org.gradle.api.*
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.*
import javax.inject.Inject

abstract class BuildToolsExtension @Inject constructor(
	private val project: Project
) {

	fun bundle(version: String) {

		val normalized = version.replace(".", "_")
		val workDir = project.layout.buildDirectory.dir("buildtools/$version")

		val buildTask = project.tasks.register<RunBuildToolsTask>("buildSpigot$normalized") {
			this.version.set(version)
			workingDir.set(workDir)
		}

		// Create configuration representing the generated spigot jar
		val spigotConfig = project.configurations.create("spigot$normalized") {
			isCanBeResolved = true
			isCanBeConsumed = false
		}

		// Make compileOnly extend from it
		project.configurations.named("compileOnly") {
			extendsFrom(spigotConfig)
		}

		// Register artifact lazily
		val jarFile = workDir.map { it.file("spigot-$version.jar") }

		project.artifacts.add(spigotConfig.name, jarFile) {
			builtBy(buildTask)
		}

		// Ensure compilation waits for jar
		project.tasks.withType(JavaCompile::class.java).configureEach {
			dependsOn(buildTask)
		}
	}
}

class BuildToolsPlugin : Plugin<Project> {
	override fun apply(project: Project) {

		project.extensions.create(
			"buildtools",
			BuildToolsExtension::class.java,
			project
		)
	}
}
