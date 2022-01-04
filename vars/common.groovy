//def sonarQube() {
//  pintIn "Prting sonarqube testing"
//}

def sonarQube() {
  sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://34.125.104.3:9000 -Dsonar.login=admin -Dsonar.password=admin123'
}
