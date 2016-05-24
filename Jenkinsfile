node {
    stage 'Setup'

    // Get the maven tool.
    // ** NOTE: This 'M3' maven tool must be configured
    // **       in the global configuration.           
    def mvnHome = tool 'M3'
    sh "${mvnHome}/bin/mvn -version"
    
    // Get some code from a GitHub repository
    git url: 'https://github.com/eduleon/ci4j.git'
    sh "${mvnHome}/bin/mvn install"
    
}

node {
    
    // Mark the code build 'stage'....
    //stage 'Testing'
    // Run the maven build
    //sh "${mvnHome}/bin/mvn clean test"
    
    //stage 'Code Quality Analysis'
    // mvn sonar:sonar -Dsonar.jdbc.url=jdbc:postgresql://sonardb:5432/sonar -Dsonar.jdbc.driverClassName=org.postgresql.Driver -Dsonar.jdbc.username=sonar -Dsonar.jdbc.password=sonar -Dsonar.host.url=http://sonar:9000 -Dsonar.java.coveragePlugin=jacoco -Dsonar.dynamicAnalysis=reuseReports -Dsonar.jacoco.reportPath=target/jacoco.exec

    stage name: 'Code Quality Analysis', concurrency: 2
    parallel 'testing': {
        node {
            echo "hello parallel node =)"
        }
    }, 'code quality': {
        node {
            
            // Get some code from a GitHub repository
            git url: 'https://github.com/eduleon/ci4j-testing-examples.git'
            
            withEnv(["PATH+MAVEN=${tool 'M3'}/bin"]) {
                // Prepare jacoco agent to allow coverage report generation, build the project, and execute the unit tests:
                sh "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent test"

                sh "mvn -Dsonar.jdbc.url=jdbc:postgresql://sonardb:5432/sonar -Dsonar.jdbc.driverClassName=org.postgresql.Driver -Dsonar.jdbc.username=sonar -Dsonar.jdbc.password=sonar -Dsonar.host.url=http://sonar:9000 " +
                //"-Dsonar.sources=src/main/java -Dsonar.tests=src/test/java -Dsonar.java.binaries=target/classes -Dsonar.junit.reportsPath=target/surefire-reports -Dsonar.jacoco.reportPath=target/jacoco.exec " +
                //"-Dsonar.junit.reportsPath=target/surefire-reports " +
                "sonar:sonar"
            }
        }
    }

}

