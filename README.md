# Demo for gh-48399
     
## Requirements
To reproduce, you need GraalVM 25, see [GraalVM Native Image System Requirements](https://docs.spring.io/spring-boot/system-requirements.html#getting-started.system-requirements.graal). 

You can validate that by issuing the command below:

```bash
native-image --version
```

## Building the native image               

To build the native image, invokes the following:

```bash
./mvnw -Pnative native:compile
```

## Running the native image

To run the native image and have it load the configuration as expected:

```bash
target/demo-native-profile --spring.profiles.active=prod
```