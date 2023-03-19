def call() {
    pipeline {
        agent any
        options {
            ansiColor('xterm')
        }
        stages {
            stage('terraform Plan') {
                steps {
                    sh '''
                    terraform plan
                    '''
                }
            }
        }

    }
}