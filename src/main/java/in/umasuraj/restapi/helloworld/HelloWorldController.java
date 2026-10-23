package in.umasuraj.restapi.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

// REST API
// http://localhost:5000

@RestController
@AllArgsConstructor
public class HelloWorldController {

	// GET REQUEST
	// http://localhost:5000/hello-world
//	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	// GET REQUEST
	// http://localhost:5000/hello-world-bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}

	// Path Variable // Path Parameters
	// GET REQUEST
	// http://localhost:5000/hello-world/path-variable/{name}
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWordPathVariable(@PathVariable String name) {
		return new HelloWorldBean(

				String.format("Hello World, %s", name)

		);
	}

}
