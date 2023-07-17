package dependencies

import kaptTest
import org.gradle.api.artifacts.dsl.DependencyHandler
import testImplementation

fun DependencyHandler.robolectric(){
    testImplementation("org.robolectric:robolectric:4.10.2")

}