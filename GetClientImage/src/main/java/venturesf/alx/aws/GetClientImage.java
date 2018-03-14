package venturesf.alx.aws;

import java.awt.image.BufferedImage; 
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import javax.imageio.ImageIO;

import venturesf.alx.model.MBSClient;
import venturesf.alx.vo.ClientsRequest;
import venturesf.alx.vo.ClientsResponse;

import com.amazonaws.services.lambda.runtime.Context;

public class GetClientImage {
	
	public ClientsResponse getImage(ClientsRequest request, Context context) throws IOException{
		
		String requestMsg = String.format("Params in this request: %s.", request.getClientId());
		context.getLogger().log(requestMsg);
	      
		BufferedImage image = ImageIO.read(new File("images/userReal.jpg")); 	
		
		MBSClient imgClient = new MBSClient();
		imgClient.setPhotoB64(encodeToString(image, "jpg"));
		
		ClientsResponse rs = new ClientsResponse();
		rs.setClients(new ArrayList<MBSClient>());
		rs.getClients().add(imgClient);
		
		rs.setStatus("success");
	
		return rs;		
	}
	
	private String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
 
        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
 
            Base64.Encoder encoder = Base64.getEncoder();
            
            imageString = encoder.encodeToString(imageBytes);
 
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

}






