import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

/**
 * Created by Tom on 16/7/11.
 */
public class Test {

	public static String baseUrl = "http://localhost:8080/appintf";

	public static void testAddPlayTask() {
		String url = baseUrl + "/user/addPlayTask";
		String content = "{\"userToken\": \"6D07D2ED48CA11E69FC2F81654C0D75C\", \"deviceId\": \"2\", \"tag\": \"fll\", "
				+ "\"weekDay\": \"123\",\"begin\":\"10:00:00\",\"musics\":[{\"audio_id\":\"1\"},{\"audio_id\":\"2\"},"
				+ "{\"audio_id\":\"3\"},{\"audio_id\":\"4\"},{\"audio_id\":\"5\"}]}";
		sendPost(url, content);
	}

	public static void testAddDevice() {
		String url = baseUrl + "/user/addDevice";
		String content = "{\"userToken\":\"6D07D2ED48CA11E69FC2F81654C0D75C\",\"sn\":\"111111\",\"name\":\"xxxaxxabb\",\"cityId\":\"13\",\"birthDay\":\"1985-11-18\"}";
		sendPost(url, content);
	}

	public static void testControlDevice() {
		String url = baseUrl + "/user/controlDevice";
		String content = "{\"userToken\":\"6D07D2ED48CA11E69FC2F81654C0D75C\",\"deviceId\":\"111111\",\"action\":\"player\",\"cityId\":\"13\",\"birthDay\":\"1985-11-18\"}";
		sendPost(url, content);
	}
//	public static void testBandDevice(){
//		String url = baseUrl + "/user/addDevice";
//		String content = "{\"userToken\":\"6D07D2ED48CA11E69FC2F81654C0D75C\",\"sn\":\"111111\",\"name\":\"xxxxx\",\"cityId\":\"12\",\"birthDay\":\"1985-10-17\"}";
//		sendPost(url, content);
//	}
	
	public static void testAddCollectDir() {
		String url = baseUrl + "/user/addCollectDir";
		String content = "{\"userToken\":\"6D07D2ED48CA11E69FC2F81654C0D75C\",\"name\":\"xxxxx\"}";
		sendPost(url, content);
	}

	public static void testAddCollectAudio() {
		String url = baseUrl + "/user/addCollectAudio";
		String content = "{\"userToken\":\"6D07D2ED48CA11E69FC2F81654C0D75C\",\"dirId\":\"1\",\"musics\":[{\"id\":\"1\",\"type\":\"2\"},{\"id\":\"23\",\"type\":\"1\"},{\"id\":\"24\",\"type\":\"1\"},{\"id\":\"25\",\"type\":\"1\"}]}";
		sendPost(url, content);
	}

	public static void testDelCollect() {
		String url = baseUrl + "/user/delCollectDir";
		String content = "{\"userToken\":\"6D07D2ED48CA11E69FC2F81654C0D75C\",\"dirId\":\"1\"}";
		sendPost(url, content);
	}
	

	public static void testDelCollectAudio() {
		String url = baseUrl + "/user/delCollectAudio";
		String content = "{\"userToken\":\"6D07D2ED48CA11E69FC2F81654C0D75C\",\"dirId\":\"1\",\"musics\":[{\"id\":\"1\"},{\"id\":\"2\"},{\"id\":\"3\"},{\"id\":\"4\"},{\"id\":\"5\"}]}";
		sendPost(url, content);
	}
	
	public static void main(String[] args) {
		 testAddPlayTask();
//		 testAddDevice();
//		 testAddCollectDir();
//		testAddCollectAudio();
//		testDelCollect() ;
//		testDelCollectAudio() ;
	}

	private static void sendPost(String URL1, String content) {
		HttpClient client = HttpClients.createDefault();

		HttpPost post = new HttpPost(URL1);
		StringEntity entity = new StringEntity(content, "utf-8");
		entity.setContentType("application/json");
		post.setEntity(entity);
		try {
			HttpResponse resp = client.execute(post);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
				{
					HttpEntity resEntity = resp.getEntity();
					if (resEntity != null) {
						String result = EntityUtils
								.toString(resEntity, "utf-8");
						System.out.println("result = " + result);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
