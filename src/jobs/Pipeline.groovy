 def BuildJob() {
     deliveryPipelineView("Pipeline") {
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
         pipelineInstances(5)
         showAggregatedPipeline()
         columns(2)
         sorting(Sorting.TITLE)
         updateInterval(60)
         enableManualTriggers()
         showAvatars()
         showChangeLog()
         pipelines {
             component('RishidhaCenter', 'Build1')
         }
     }
    }

    BuildJob()
    def startupjob() {
        deliveryPipelineView("Pipeline") {
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
            }
        }
    }
    startupjob()
