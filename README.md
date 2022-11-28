# API Validation for the 'Search' service

API automation using Serenity, Rest Assured and Cucumber for the 'Search' endpoint.

Recent changes:
 - Fixed SearchStepDefinitions logic('Than' cases);
 - Changed positive cucumber scenario to Outline with one more step. 
Now it uses different input values and check status codes with the response body fields;
 - Added 1 negative scenario for not existing fruit search;
 - Removed unused files and directories like: gradle, CarsAPI, github, history, .m2;
 - Remove unused files from the .gitignore;
 - Removed temporary directory: target;
 - Updated the pom.xml: removed unused sections, updated most dependencies; 
 - Added serenity-single-page-report in the pom.xml.
 - Added gitlab-ci.yml. GitLab CI configuration;
 - Updated the README.md.

## 📦 How do I set up

### Pre-requisite:
    These should be installed in your local machine.
    * Java 17
    * Maven 3.6.3
    * Set up the environment variables: JAVA_HOME and MVN_HOME.
    * Check the environment base configuration. in the terminal execute: mvn -v



#### Clone the project into your local directory(SSH or HTTPS)  
  - via SSH:
```sh
git clone git@gitlab.com:dfaliush/soft_industry_example.git
```
  - via HTTPS
```sh
git clone https://gitlab.com/dfaliush/soft_industry_example.git
```

## <img src="https://raw.githubusercontent.com/FortAwesome/Font-Awesome/6.x/svgs/solid/wrench.svg" width="30" height="25">  Build
Go to the project's root directory and Run
```sh
mvn clean compile
```

## ✅ Test
Run the tests using the command as below or use 'Run' function in your IDE on search_api_test.feature
```sh
mvn verify
```
## 📈 Reports
The reports will be located at target/site/serenity/index.html:

## 💚 Gitlab Integration

- The tests are set to run in the [pipeline](https://gitlab.com/dfaliush/soft_industry_example/-/pipelines) in GitLab for every checkin.
- Add Gitlab config file `.gitlab-ci.yml`
    - Add the stage to compile teh project
    - Add the stage to run tests
    - Add the stage to generate report
- You can trigger the [pipeline](https://gitlab.com/dfaliush/soft_industry_example/-/pipelines) by clicking on "Run Pipeline" in the UI.
- HTML report is saved as artifacts for each job run in the 
  - gitlab.com/{username}/soft_industry_example/-/jobs/{job_number}/artifacts/browse

  Refer [Detailed HTML Report](https://dfaliush.gitlab.io/-/soft_industry_example/-/jobs/3385207023/artifacts/target/site/serenity/index.html).

  Refer [Single Page HTML Report](https://dfaliush.gitlab.io/-/soft_industry_example/-/jobs/3385207024/artifacts/target/site/serenity/serenity-summary.html).

## 🥒 Extending Tests

- Add new test scenarios in the feature file [search_api_test.feature](/src/test/resources/features/search/search_api_test.feature)
- Add corresponding steps for the new scenarios in the stepDefinitions file [SearchStepDefinitions](/src/test/java/starter/stepdefinitions/SearchStepDefinitions.java)


Refer further: 
 - [Cucumber Documentation](https://cucumber.io/docs/guides/10-minute-tutorial/#write-a-scenario)
 - [Serenity Cucumber Starter](https://github.com/serenity-bdd/serenity-cucumber-starter)
