# Recaptcha_login
Project to demonstrate recaptcha usage in user login

TECH USED:

- Thymeleaf for serving html page
- Spring Boot for designing our controller, service, and persistence layer.
- Spring Security to handle user registration.
- Mongo DB configurations are used for external mongo setup locally. In-memory
  mongo db could be setup using flapdoodle library.

APPLICATION USAGE:

1.) Generate a google recaptcha secret key and site key through this site:
    https://www.google.com/recaptcha/admin/create

2.) Store the secret key in application.properties.

3.) Include the site key in the static html page "register_recaptcha.html".

4.) Setup a mongo db database locally. Add a collection with the name 'users'.
    Override the mongo credentials in application.properties if required.

5.) Run the application and hit localhost:8080/registration endpoint.

6.) After successful registration, hit the endpoint again or refresh to go 
back to the registration screen.

APPLICATION SETUP FOR VSCODE:

1.) Install Java Extension pack for VS CODE (https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
2.) View Menu -> CommandPalette -> Tasks: Configure Task
3.) Change the options as follows: 
    .
    .
    .
    "tasks": [
        {
            "label": "install",
            "type": "shell",
            "command": "mvn -B install",
            "group": "build"
        }
    ]
4.) View Menu -> CommandPalette -> Tasks: Run Build Task -> install

5.) After succesfull install, navigate to target -> registration-0.0.1-SNAPSHOT.jar

6.) Open Terminal and run the jar as : java -jar registration-0.0.1-SNAPSHOT.jar

7.) You can hit the application from localhost after that by follwing the steps given in 'APPLICATION USAGE' section. 

