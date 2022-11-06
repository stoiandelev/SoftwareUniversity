//anotation do not be in FUTURE
@PastoRPresent
@FutureOrPresent

//hash Password
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
}

userRegisterDTO.setPassword(passwordEncoder.encode(userRegisterDTO.getConfirmPassword()));

//take the user properties if password dont maches
UserEntity loginUser = optionalUser.get();
    if (!passwordEncoder.matches(password, loginUser.getPassword())) {
            return false;
}



//UUID
@ID
@GeneratedValue(generator = "uuid-string")
@GenericGenerator(name = "uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
public String id;


//if we use HttpSession
<th:block th:if="${session.isEmpty()}"> 
<th:block th:unless="${session.isEmpty()}">

//bellow controller
@RequestMapping("/users")

//for check fields errors bellow them in <span>
th:field="*{firstName}" th:errorclass="bg-danger"
th:if="${#fields.hasErrors('firstName')}" th:errors="*{firstName}"

//for form 
th:action="@{/users/register}"
th:method="POST"
th:object="${userRegisterDTO}"

//<!---If we want see errors above fields--->
<th:block th:each="e : ${#fields.errors()}" th:object="${e}">
    <small th:text="${e}" class="text-danger">Error message</small>
    <br/>
</th:block>

//for forEach on every enums values
<option th:each="c : ${T (com.example.favouritePlaceInTheWorld.entity.enums.ContinentEnum).values() }"
         th:value="${c}" th:text="${c}">ASIA</option>

//how i get id
th:href="@{/songs/add/{id} (id = *{song.id}) }"

//for nav with sessionUser
th:if="${@userSession.id == null}"

//dependancy thymeleaf sec
<dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity5</artifactId>
</dependency>









