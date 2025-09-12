package filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        logRequest(requestSpec);
        //as we have intercepted to get the request details, now we need to tell
        // it to continue with request execution at server. hence we write below code
        Response response=ctx.next(requestSpec, responseSpec);
        logResponse(response);
        return response;//we are returning the control to test so that further action over there like assertion can happen
    }

    public void logRequest(FilterableRequestSpecification requestSpec) {
        logger.info("BASE URI:"+ requestSpec.getBaseUri());
        logger.info("Request Header:"+ requestSpec.getHeaders());
        logger.info("Request PayLoad:"+ requestSpec.getBody());
    }

    public void logResponse(Response response) {
        logger.info("STATUS CODE:"+ response.getStatusCode());
        logger.info("Response Header :"+ response.headers());
        logger.info("Request Body:"+ response.getBody().prettyPrint());
    }

}