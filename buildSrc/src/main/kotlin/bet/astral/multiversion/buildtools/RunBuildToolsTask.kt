package bet.astral.multiversion.buildtools

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import java.io.File
import java.net.URI
import javax.inject.Inject

abstract class RunBuildToolsTask @Inject constructor(
	private val execOps: ExecOperations
) : DefaultTask() {

	@get:Input
	abstract val version: Property<String>

	@get:OutputDirectory
	abstract val workingDir: DirectoryProperty

	@TaskAction
	fun run() {
		val dir = workingDir.get().asFile
		dir.mkdirs()

		val buildTools = File(dir, "BuildTools.jar")

		if (!buildTools.exists()) {
			logger.lifecycle("Downloading BuildTools...")
			URI("https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar")
				.toURL()
				.openStream().use { input ->
					buildTools.outputStream().use { input.copyTo(it) }
				}
		}

		val outputJar = File(dir, "spigot-${version.get()}.jar")
		if (outputJar.exists()) {
			logger.lifecycle("Spigot ${version.get()} already built.")
			return
		}

		logger.lifecycle("Building Spigot ${version.get()}...")

		execOps.exec {
			workingDir(dir)
			commandLine(
				"java",
				"-jar",
				buildTools.absolutePath,
				"--rev",
				version.get()
			)
		}
	}
}
