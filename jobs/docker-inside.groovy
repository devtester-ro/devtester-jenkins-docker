node('test-agent') {
    stage "Container Prep"
    // do the thing in the container
    docker.image('maven:3.3.3-jdk-8').inside {
        // get the codez
        stage 'Checkout'
        git url: 'https://github.com/damnhandy/Handy-URI-Templates.git'
        stage 'Build'
        // Run the build
        // sh "./mvnw clean install" (test this after jenkins fix the inside sh
    }
}
