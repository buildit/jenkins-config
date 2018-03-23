pipelineJob('hello-k8s') {
    definition {
        cps {
            sandbox()
            script("""
pipeline {
    agent {
        kubernetes {
            label 'k8s'
            inheritFrom 'base'
            containerTemplate {
                name 'maven'
                image 'alpine:3.7'
                ttyEnabled true
                command 'cat'
            }
        }
    }
    stages {
        stage('say hello') {
            steps {
                script {
                    sh("echo k8s")
                }
            }
        }
    }
}
      """.stripIndent())
        }
    }
}