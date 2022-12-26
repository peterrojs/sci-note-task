# Laboratory Plate Generator

This application provides a REST function for generating the contents of laboratory plates for a series of experiments. The purpose of the function is to optimize the placement of samples and reagents in the plates in a way that makes it easy for laboratory technicians to prepare the plates.

# Installation

To use the project you need Java 17 installed. The JDK used for development was GraalVM for the purposes of optimizing performance and memory footprint.

To create a bootable JAR run:

`./gradlew bootJar`

If you would like to utilize the power of native compilation, the GraalVM native-image compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.:

`./gradlew nativeRun`