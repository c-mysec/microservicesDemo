package xom;

import java.util.Optional;

import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

public class GreeterHandler {

	@FunctionName("greeter")
	public String execute(
		@HttpTrigger(name = "req", methods = {HttpMethod.GET,
			HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> foo,
		ExecutionContext context) {
		Greeter g = new Greeter();
		return g.apply(foo.getBody().get());//handleRequest(foo.getBody().get(), context);

	}
}
