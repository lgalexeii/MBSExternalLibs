package venturesf.alx.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import venturesf.alx.aws.GetClientImage;
import venturesf.alx.vo.ClientsRequest;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class GetClientImageTest {
	
	ClientsRequest request;
	Context context;

	@Before
	public void setUp() throws Exception {
		request = new ClientsRequest();
		request.setClientId("1001");
		
			context = new Context() {
			
			@Override
			public int getRemainingTimeInMillis() {
				return 0;
			}
			
			@Override
			public int getMemoryLimitInMB() {
				return 0;
			}
			
			@Override
			public LambdaLogger getLogger() {
				return new LambdaLogger() {
					
					@Override
					public void log(String arg0) {
						System.out.print(arg0);
						
					}
				};
			}
			
			@Override
			public String getLogStreamName() {
				return null;
			}
			
			@Override
			public String getLogGroupName() {
				return null;
			}
			
			@Override
			public String getInvokedFunctionArn() {
				return null;
			}
			
			@Override
			public CognitoIdentity getIdentity() {
				return null;
			}
			
			@Override
			public String getFunctionVersion() {
				return null;
			}
			
			@Override
			public String getFunctionName() {
				return null;
			}
			
			@Override
			public ClientContext getClientContext() {
				return null;
			}
			
			@Override
			public String getAwsRequestId() {
				return null;
			}
		};
		
		
	}

	@Test
	public void testGetImage() throws IOException {
		GetClientImage gci = new GetClientImage();		
		
		String imgb64 = gci.getImage(request, context ).getClients().get(0).getPhotoB64() ;
		assertNotNull(imgb64);
		context.getLogger().log(imgb64);
	}

}
