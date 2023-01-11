 def BuildJob() {
     deliveryPipelineView("EmailNotificationDSL") {
         job('Build1') {
             description('This job is to build a docker file and generate image')
             deliveryPipelineConfiguration('CI1', 'Build1')
             scm {
                 git {
                     remote {
                         url('git@github.com:rishidha/hello-world.git')
                         credentials('github')
                         branch('*/master')
                     }
                 }
             }
             steps {
                 shell('echo "Testing"')
             }
             publishers {
                 downstream("Startup Application1")
             }
         }
     }
    }
    BuildJob()
    def startupjob() {
        deliveryPipelineView("EmailNotificationDSL") {
            job('Startup Application1') {
                description('This job is to build a docker file and generate image')
                deliveryPipelineConfiguration('CI1', 'Startup Application1')
                scm {
                    git {
                        remote {
                            url('git@github.com:rishidha/hello-world.git')
                            credentials('github')
                            branch('*/master')
                        }
                    }
                }
                steps {
                    shell('echo "Testing"')
                }
                publishers {
                    downstream("Startup Application1")
                }
            }
        }
    }
    startupjob()
