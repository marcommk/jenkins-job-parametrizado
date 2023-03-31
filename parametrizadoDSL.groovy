job('ejemplo2-job-DSL') {
  description('Job DSL de ejmplo para el curso de Jenkins')
  scm{
    git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
      node/gitConfigName('macloujulian')
      node/gitConfigEmail('macloujulian@gmail.com')
    }
    parameters{
      stringParam('nombre', defaultValue = 'MMK', description = 'Parametro de cadena para el Job Booleano')
      choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
      booleanParam('agente', false)
    }
    triggers{
    	cron('H/7 * * * *')
    }
    steps{
      shell("bash jobscript.sh")
    }
    publishers{
    	mailer('marco.martinez@mmkgroup.com.mx', true, true)
    }
  }
}
