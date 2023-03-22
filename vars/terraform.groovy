def call() {
    pipeline {

        agent any

        parameters {
            choice(name: 'ENVIRONMENT', choices: ['', 'dev', 'prod'], description: 'Pick Environment', defaultValue: '')
            choice(name: 'ACTION', choices: ['', 'apply', 'destroy'], description: 'Pick Terraform Action', defaultValue: '')
        }

        stages {
            stage('Terraform Init') {
                steps {
                    sh """
                      terraform init -backend-config=env/${ENVIRONMENT}-backend.tfvars
                    """
                }
            }

            stage('Terraform Plan') {
                steps {
                    sh """
                      terraform plan -var-file=env/${ENVIRONMENT}.tfvars
                    """
                }
            }
        }
    }
}