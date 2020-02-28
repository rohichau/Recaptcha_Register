# Register with Google Recaptcha
Project to demonstrate recaptcha usage in user login

TECH USED:

- Thymeleaf for serving html page
- Spring Boot for designing our controller, service, and persistence layer.
- Spring Security to handle user registration.
- Mongo DB configurations are used for external mongo setup locally. In-memory
  mongo db could be setup using flapdoodle library.
- Basic bootstrap for registration form.

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
