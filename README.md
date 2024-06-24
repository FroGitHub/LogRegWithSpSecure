
Problem:
***************************
APPLICATION FAILED TO START
***************************

Description:

The dependencies of some of the beans in the application context form a cycle:

┌─────┐
|  securityConfig defined in file [C:\Users\user\Desktop\RegAndLogWithSecure\target\classes\com\example\RegAndLogWithSecure\userThings\SecurityConfig.class]
↑     ↓
|  userService defined in file [C:\Users\user\Desktop\RegAndLogWithSecure\target\classes\com\example\RegAndLogWithSecure\userThings\UserService.class]
└─────┘


Action:

Relying upon circular references is discouraged and they are prohibited by default. Update your application to remove the dependency cycle between beans. As a last resort, it may be possible to break the cycle automatically by setting spring.main.allow-circular-references to true.


Solution: add @Lazy in constructor

    private final UserService userService;

    @Autowired
    public SecurityConfig(@Lazy UserService userService) {
        this.userService = userService;
    }
