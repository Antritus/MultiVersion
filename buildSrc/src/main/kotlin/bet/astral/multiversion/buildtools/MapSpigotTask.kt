package bet.astral.multiversion.buildtools

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

abstract class MapSpigotTask : DefaultTask() {

    @get:Input
    abstract val version: Property<String>

    @get:InputDirectory
    abstract val workingDir: DirectoryProperty

    @get:OutputDirectory
    val outputDir: DirectoryProperty = project.objects.directoryProperty()

    init {
        outputDir.set(
            project.layout.buildDirectory.dir("generated/spigot/${version.orNull ?: "unknown"}")
        )
    }

    @TaskAction
    fun run() {
        val dir = workingDir.get().asFile

        val spigotJar = dir.walkTopDown()
            .firstOrNull { it.name == "spigot-${version.get()}.jar" }
            ?: throw GradleException("Spigot jar not found")

        val srcDir = dir.walkTopDown()
            .firstOrNull { it.name == "src" && it.parentFile.name.contains("Spigot-Server") }
            ?: throw GradleException("Spigot source not found")

        val out = project.layout.buildDirectory
            .dir("generated/spigot/${version.get()}")
            .get().asFile

        srcDir.copyRecursively(out, overwrite = true)

        project.dependencies.add(
            "implementation",
            project.files(spigotJar)
        )

        logger.lifecycle("Spigot ${version.get()} mapped successfully.")
    }
}
