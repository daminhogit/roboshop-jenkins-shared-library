def call() {
    pipeline {
        agent any

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