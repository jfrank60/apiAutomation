pipeline {
	agent any
	stages {
		stage('Compile Stage')
			steps {
				withMaven(maven : 'apache-maven-4.0.0') {
					bat 'mvn clean compile'
					}
				}
			}
		stage('Testing Stage') {
			steps {
				withMaven(maven : 'apache-maven-4.0.0') {
					bat 'mvn test'
				}
			}
		}
	}