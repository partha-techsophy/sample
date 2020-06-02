## Sample Mockito project

This project follows **Domain Driven Design**

[Creating Coding Excellence with Domain-driven Design](https://medium.com/swlh/creating-coding-excellence-with-domain-driven-design-88f73d2232c3)

Controller, Service and Repository is decoupled to enable changes without impacting any of the layer.

Between Controller and Service there is a Service port which decouples Controller and Service.

Between Service and Repository there is a port which decouples Service and Repository.

To run the demo application execute _gradle bootRun_

To run test cases in demo application execute _gradle clean test_

## Details

###### Requirements:
1. Gradle 6.3 or above
2. Java 11 or above
3. IDE - Intellij or Eclipse

#### Mockito test integration
This demo project uses [Mockito](https://site.mockito.org/) to test our application.

We are using JUnit 5 test case with Mockito2. 
_**Basic rules**: Springboot scans components from @SpringBootApplication directory and subdirectories. Make sure that all other classes are bellow or at the same level._

To run the JUnit 5 test case with Mockito2, we use Jupiter extensions support, and here, we will use the Mockito extension. The purpose of the JUnit 5 extensions is to extend the behavior of test classes or methods, and these can be reused for multiple tests. 

`@Mock UserRepositoryPortImpl userRepository` creates a mock repository.

`@InjectMocks UserServiceImpl userService` Inject the mocks as dependencies into userService.

`@ExtendWith(MockitoExtension.class)` The JUnit Runner which causes all the initialization magic with @Mock and @InjectMocks to happen before the tests are run.

Using mockito we will test the following
1. Service layer
2. Controller
3. RestClient, to test third party API
 
##### Testing service layer
Stubbing appears before the actual execution
`when(userRepository.add(any(User.class))).thenReturn(user);`

Selective, explicit, highly readable verification
`verify(userRepository, times(1)).add(any(User.class));`

or by assertion statements, match the email in the returned object to be equal to the one set by you in the mocked object
`Assertions.assertEquals(savedUser.getName(), user.getEmail());`

##### Testing Controller layer
Initialize the Controller 

`@WebMvcTest(controllers = UserController.class)` @WebMvcTest annotation to fire up an application context that contains only the beans needed for testing a web controller

`@ActiveProfiles("Test")` declare which active bean definition profiles should be used when loading an ApplicationContext for test classes.

`@Autowired MockMvc mockMvc;` initiate MockMvc

`@BeforeEach void setUp()` setup mock data

Create the stub
`when(userService.getAll()).thenReturn(userList);`

Perform test
`this.mockMvc
    .perform(get("/api/1.0.0/users"))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.size()", is(userList.size())))
    .andExpect(jsonPath("$[0].id", is(1)));`
    
For post request ArgumentCaptor can be used to test POST data
    
`ArgumentCaptor<UserDTO> anyUser = forClass(UserDTO.class);
        verify(userService).createUser(anyUser.capture());
        assertThat(anyUser.getValue().getEmail()).isEqualTo("default@email.com");`
        
Testing Exception
`this.mockMvc
        .perform(get("/api/1.0.0/users/10"))
        .andExpect(status().isNotFound());`        
        
        
##### Testing RestClient
Initialize the test class
`@RestClientTest` annotation helps simplify and speed up the testing of REST clients in your Spring applications.
@RestClientTest ensures that Jackson and GSON support is auto-configured, and also adds pre-configured RestTemplateBuilder and MockRestServiceServer instances to the context.

`@Autowired MockRestServiceServer server;` initialize mockserver.

To test call the third party service and test
`server
.expect(once(), requestTo(startsWith("/some-client")))
.andExpect(method(HttpMethod.GET))`


        