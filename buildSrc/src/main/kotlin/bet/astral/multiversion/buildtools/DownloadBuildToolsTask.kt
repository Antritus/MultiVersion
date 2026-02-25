package bet.astral.multiversion.buildtools

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.net.URI

abstract class DownloadBuildToolsTask : DefaultTask() {

    @get:Input
    abstract val version: Property<String>

    @get:OutputDirectory
    abstract val outputDir: DirectoryProperty

    @TaskAction
    fun run() {
        val dir = outputDir.get().asFile
        dir.mkdirs()

        val target = File(dir, "BuildTools.jar")
        if (target.exists()) {
            logger.lifecycle("BuildTools already exists.")
            return
        }

        logger.lifecycle("Downloading BuildTools...")

        URI("https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar")
			.toURL()
            .openStream().use { input ->
                target.outputStream().use { output ->
                    input.copyTo(output)
                }
            }
    }
}
