pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }

    stages {

        stage('Compile') {
            steps {
                gradlew('clean', 'classes')
            }
        }
        stage('build') {
            steps {
                gradlew('build')
                stash includes: '**/build/libs/*.jar', name: 'app'
            }
        }
        stage('Promotion') {
            steps {
                timeout(time: 1, unit:'DAYS') {
                    input 'Deploy to Production?'
                }
            }
        }
        stage('Deploy to Production') {
            environment {
                HEROKU_API_KEY = credentials('HEROKU_API_KEY')
            }
            steps {
                unstash 'app'
                gradlew('deployHeroku')
            }
        }
    }

}

def gradlew(String... args) {
    sh "./gradlew ${args.join(' ')} -s"
}